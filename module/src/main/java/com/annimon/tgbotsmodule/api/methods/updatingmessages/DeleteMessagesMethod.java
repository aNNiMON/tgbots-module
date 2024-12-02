package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessages;

public class DeleteMessagesMethod implements ChatMethod<DeleteMessagesMethod, Boolean> {

    private final DeleteMessages.DeleteMessagesBuilder<?, ?> method;

    public DeleteMessagesMethod() {
        this(DeleteMessages.builder());
    }

    public DeleteMessagesMethod(@NotNull DeleteMessages.DeleteMessagesBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public DeleteMessagesMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public List<Integer> getMessageIds() {
        return method.build().getMessageIds();
    }

    public DeleteMessagesMethod setMessageIds(@NotNull List<Integer> messageIds) {
        method.messageIds(messageIds);
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
