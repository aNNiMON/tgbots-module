package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.UnbanChatSenderChat;

public class UnbanChatSenderChatMethod implements ChatMethod<UnbanChatSenderChatMethod, Boolean> {

    private final UnbanChatSenderChat.UnbanChatSenderChatBuilder method;

    public UnbanChatSenderChatMethod() {
        this(UnbanChatSenderChat.builder());
    }

    public UnbanChatSenderChatMethod(@NotNull UnbanChatSenderChat.UnbanChatSenderChatBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public UnbanChatSenderChatMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public Long getSenderChatId() {
        return method.build().getSenderChatId();
    }

    public UnbanChatSenderChatMethod setSenderChatId(@NotNull Long senderChatId) {
        method.senderChatId(senderChatId);
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
