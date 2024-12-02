package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

public class DeleteMessageMethod implements ChatMessageMethod<DeleteMessageMethod, Boolean> {

    private final DeleteMessage.DeleteMessageBuilder<?, ?> method;

    public DeleteMessageMethod() {
        this(DeleteMessage.builder());
    }

    public DeleteMessageMethod(@NotNull DeleteMessage.DeleteMessageBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public DeleteMessageMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public DeleteMessageMethod setMessageId(@NotNull Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
