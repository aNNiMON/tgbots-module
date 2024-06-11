package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.pinnedmessages.UnpinAllChatMessages;

public class UnpinAllChatMessagesMethod implements ChatMethod<UnpinAllChatMessagesMethod, Boolean> {

    private final UnpinAllChatMessages.UnpinAllChatMessagesBuilder method;

    public UnpinAllChatMessagesMethod() {
        this(UnpinAllChatMessages.builder());
    }

    public UnpinAllChatMessagesMethod(@NotNull UnpinAllChatMessages.UnpinAllChatMessagesBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public UnpinAllChatMessagesMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
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
