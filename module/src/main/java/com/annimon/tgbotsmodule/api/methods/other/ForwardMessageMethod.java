package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ForwardMessageMethod implements
        ChatMessageMethod<ForwardMessageMethod, Message>,
        NotificationMethod<ForwardMessageMethod, Message> {

    private final ForwardMessage method;

    public ForwardMessageMethod() {
        this(new ForwardMessage());
    }

    public ForwardMessageMethod(@NotNull ForwardMessage method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public ForwardMessageMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.getMessageId();
    }

    @Override
    public ForwardMessageMethod setMessageId(@NotNull Integer messageId) {
        method.setMessageId(messageId);
        return this;
    }

    public String getFromChatId() {
        return method.getFromChatId();
    }

    public ForwardMessageMethod setFromChatId(@NotNull String chatId) {
        method.setFromChatId(chatId);
        return this;
    }

    public ForwardMessageMethod setFromChatId(long chatId) {
        return setFromChatId(Long.toString(chatId, 10));
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public ForwardMessageMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public ForwardMessageMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public Message call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Message> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
