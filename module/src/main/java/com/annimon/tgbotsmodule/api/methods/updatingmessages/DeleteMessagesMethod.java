package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessages;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeleteMessagesMethod implements ChatMethod<DeleteMessagesMethod, Boolean> {

    private final DeleteMessages method;

    public DeleteMessagesMethod() {
        this(new DeleteMessages());
    }

    public DeleteMessagesMethod(@NotNull DeleteMessages method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public DeleteMessagesMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public List<Integer> getMessageIds() {
        return method.getMessageIds();
    }

    public DeleteMessagesMethod setMessageIds(@NotNull List<Integer> messageIds) {
        method.setMessageIds(messageIds);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Boolean> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
