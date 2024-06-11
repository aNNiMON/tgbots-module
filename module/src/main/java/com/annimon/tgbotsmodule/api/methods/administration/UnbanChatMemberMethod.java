package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.UnbanChatMember;

public class UnbanChatMemberMethod implements ChatMemberMethod<UnbanChatMemberMethod, Boolean> {

    private final UnbanChatMember.UnbanChatMemberBuilder method;

    public UnbanChatMemberMethod() {
        this(UnbanChatMember.builder());
    }

    public UnbanChatMemberMethod(@NotNull UnbanChatMember.UnbanChatMemberBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public UnbanChatMemberMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public UnbanChatMemberMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public Boolean getOnlyIfBanned() {
        return method.build().getOnlyIfBanned();
    }

    public UnbanChatMemberMethod setOnlyIfBanned(Boolean onlyIfBanned) {
        method.onlyIfBanned(onlyIfBanned);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
