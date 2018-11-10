package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.pinnedmessages.PinChatMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PinChatMessageMethod implements
        ChatMessageMethod<PinChatMessageMethod, Boolean>,
        NotificationMethod<PinChatMessageMethod, Boolean> {

    private final PinChatMessage method;

    public PinChatMessageMethod() {
        this(new PinChatMessage());
    }

    public PinChatMessageMethod(@NotNull PinChatMessage method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public PinChatMessageMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.getMessageId();
    }

    @Override
    public PinChatMessageMethod setMessageId(@NotNull Integer messageId) {
        method.setMessageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public PinChatMessageMethod enableNotification() {
        method.setDisableNotification(false);
        return this;
    }

    @Override
    public PinChatMessageMethod disableNotification() {
        method.setDisableNotification(true);
        return this;
    }

    @Override
    public PinChatMessageMethod setNotificationEnabled(boolean status) {
        method.setDisableNotification(!status);
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
