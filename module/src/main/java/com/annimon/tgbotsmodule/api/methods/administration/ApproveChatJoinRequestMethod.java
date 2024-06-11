package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.ApproveChatJoinRequest;

public class ApproveChatJoinRequestMethod implements ChatMemberMethod<ApproveChatJoinRequestMethod, Boolean> {

    private final ApproveChatJoinRequest.ApproveChatJoinRequestBuilder method;

    public ApproveChatJoinRequestMethod() {
        this(ApproveChatJoinRequest.builder());
    }

    public ApproveChatJoinRequestMethod(@NotNull ApproveChatJoinRequest.ApproveChatJoinRequestBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public ApproveChatJoinRequestMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public ApproveChatJoinRequestMethod setUserId(@NotNull Long userId) {
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
