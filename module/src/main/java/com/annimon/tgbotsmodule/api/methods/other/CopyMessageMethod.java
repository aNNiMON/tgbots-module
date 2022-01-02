package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.objects.MessageId;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CopyMessageMethod implements
        ChatMessageMethod<CopyMessageMethod, MessageId>,
        NotificationMethod<CopyMessageMethod, MessageId>,
        ProtectedContentMethod<CopyMessageMethod, MessageId> {

    private final CopyMessage method;

    public CopyMessageMethod() {
        this(new CopyMessage());
    }

    public CopyMessageMethod(@NotNull CopyMessage method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public CopyMessageMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.getMessageId();
    }

    @Override
    public CopyMessageMethod setMessageId(@NotNull Integer messageId) {
        method.setMessageId(messageId);
        return this;
    }

    public String getFromChatId() {
        return method.getFromChatId();
    }

    public CopyMessageMethod setFromChatId(@NotNull String chatId) {
        method.setFromChatId(chatId);
        return this;
    }

    public CopyMessageMethod setFromChatId(long chatId) {
        return setFromChatId(Long.toString(chatId, 10));
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public CopyMessageMethod enableNotification() {
        method.setDisableNotification(false);
        return this;
    }

    @Override
    public CopyMessageMethod disableNotification() {
        method.setDisableNotification(true);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.getProtectContent();
    }

    @Override
    public CopyMessageMethod setProtectContent(Boolean protectContent) {
        method.setProtectContent(protectContent);
        return this;
    }

    @Override
    public MessageId call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super MessageId> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
