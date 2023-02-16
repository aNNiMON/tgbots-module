package com.annimon.tgbotsmodule.commands.authority;

import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.time.Duration;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class SimpleAuthority implements Authority<For> {

    private final long creatorId;
    private final Set<Long> botAdmins;
    private final Map<String, Map.Entry<Long, Set<Long>>> chatAdmins;
    private long adminUpdatesTimeInSec;

    public SimpleAuthority(long creatorId) {
        this.creatorId = creatorId;
        botAdmins = ConcurrentHashMap.newKeySet();
        chatAdmins = new ConcurrentHashMap<>();
        adminUpdatesTimeInSec = TimeUnit.HOURS.toSeconds(12);
    }

    public void setAdminUpdatesTime(TimeUnit unit, long value) {
        adminUpdatesTimeInSec = Objects.requireNonNull(unit).toSeconds(value);
    }

    public void setAdminUpdatesTime(Duration duration) {
        adminUpdatesTimeInSec = Objects.requireNonNull(duration).toSeconds();
    }

    public long getCreatorId() {
        return creatorId;
    }

    public @NotNull Set<Long> getBotAdmins() {
        return botAdmins;
    }

    public SimpleAuthority addBotAdmin(Long id) {
        botAdmins.add(id);
        return this;
    }

    public boolean isGroupChat(Update update) {
        if (update == null || !update.hasMessage()) {
            return false;
        }
        final var chat = update.getMessage().getChat();
        return !chat.isUserChat();
    }

    public boolean isGroupAdmin(@NotNull CommonAbsSender sender, @NotNull Long userId, @NotNull Long chatId) {
        return isGroupAdmin(sender, userId, Long.toString(chatId));
    }

    public boolean isGroupAdmin(@NotNull CommonAbsSender sender, @NotNull Long userId, @NotNull String chatId) {
        final var entry = chatAdmins.get(chatId);
        final Set<Long> admins;
        if (needUpdateChatAdmins(entry)) {
            admins = Methods.getChatAdministrators(chatId)
                    .call(sender).stream()
                    .map(d -> d.getUser().getId())
                    .collect(Collectors.toSet());
            chatAdmins.put(chatId, Map.entry(time(), admins));
        } else {
            admins = entry.getValue();
        }
        return admins.contains(userId);
    }

    @Override
    public boolean hasRights(@NotNull CommonAbsSender sender, @NotNull Update update, @NotNull User user, @NotNull EnumSet<For> roles) {
        final long userId = user.getId();
        final boolean isCreator = (userId == creatorId);
        if (isCreator) {
            return true;
        }

        if (roles.contains(For.USER))
            return true;

        if (roles.contains(For.GROUP_ADMIN)){
            if (botAdmins.contains(userId)
                || (isGroupChat(update) && isGroupAdmin(sender, userId, update.getMessage().getChatId())))
                return true;
        }

        if (roles.contains(For.ADMIN) && botAdmins.contains(userId))
            return true;

        return false;
    }

    private boolean needUpdateChatAdmins(Map.Entry<Long, Set<Long>> entry) {
        if (entry == null) return true;
        if (entry.getValue().isEmpty()) return true;
        if (entry.getKey() + adminUpdatesTimeInSec < time()) {
            return true;
        }
        return false;
    }

    private long time() {
        return System.currentTimeMillis() / 1000L;
    }
}
