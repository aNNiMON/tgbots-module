package com.annimon.tgbotsmodule.commands.authority;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.LongStream;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

/**
 * Allows access for predefined list of users
 */
public class PredefinedAccessAuthority implements Authority<For> {
    private final Set<Long> allowedUsers;

    public PredefinedAccessAuthority(long userId) {
        this(List.of(userId));
    }

    public PredefinedAccessAuthority(Collection<Long> allowedUsers) {
        this.allowedUsers = ConcurrentHashMap.newKeySet();
        this.allowedUsers.addAll(allowedUsers);
    }

    public PredefinedAccessAuthority allowAccess(long userId) {
        allowedUsers.add(userId);
        return this;
    }

    public PredefinedAccessAuthority removeAccess(long userId) {
        allowedUsers.remove(userId);
        return this;
    }

    public LongStream allowedUsers() {
        return allowedUsers.stream().mapToLong(Long::longValue);
    }

    @Override
    public boolean hasRights(@NotNull CommonAbsSender sender, @NotNull Update update, @NotNull User user, @NotNull EnumSet<For> roles) {
        return allowedUsers.contains(user.getId());
    }
}
