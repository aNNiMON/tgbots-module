package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageThreadMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.ForwardMessages;
import org.telegram.telegrambots.meta.api.objects.MessageId;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ForwardMessagesMethod implements
        ChatMessageThreadMethod<ForwardMessagesMethod, ArrayList<MessageId>>,
        NotificationMethod<ForwardMessagesMethod, ArrayList<MessageId>>,
        ProtectedContentMethod<ForwardMessagesMethod, ArrayList<MessageId>> {

    private final ForwardMessages method;

    public ForwardMessagesMethod() {
        this(new ForwardMessages());
    }

    public ForwardMessagesMethod(@NotNull ForwardMessages method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public ForwardMessagesMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    public ForwardMessagesMethod setMessageThreadId(@NotNull Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
        return this;
    }

    public String getFromChatId() {
        return method.getFromChatId();
    }

    public ForwardMessagesMethod setFromChatId(@NotNull String chatId) {
        method.setFromChatId(chatId);
        return this;
    }

    public ForwardMessagesMethod setFromChatId(long chatId) {
        method.setFromChatId(chatId);
        return this;
    }

    public List<Integer> getMessageIds() {
        return method.getMessageIds();
    }

    public ForwardMessagesMethod setMessageIds(@NotNull List<Integer> messageIds) {
        method.setMessageIds(messageIds);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public ForwardMessagesMethod enableNotification() {
        method.setDisableNotification(false);
        return this;
    }

    @Override
    public ForwardMessagesMethod disableNotification() {
        method.setDisableNotification(true);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.getProtectContent();
    }

    @Override
    public ForwardMessagesMethod setProtectContent(Boolean protectContent) {
        method.setProtectContent(protectContent);
        return this;
    }

    @Override
    public ArrayList<MessageId> call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super ArrayList<MessageId>> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
