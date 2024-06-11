package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.DeclineChatJoinRequest;

public class DeclineChatJoinRequestMethod implements ChatMemberMethod<DeclineChatJoinRequestMethod, Boolean> {

    private final DeclineChatJoinRequest.DeclineChatJoinRequestBuilder method;

    public DeclineChatJoinRequestMethod() {
        this(DeclineChatJoinRequest.builder());
    }

    public DeclineChatJoinRequestMethod(@NotNull DeclineChatJoinRequest.DeclineChatJoinRequestBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public DeclineChatJoinRequestMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public DeclineChatJoinRequestMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
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
