package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageThreadMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.ForwardMessages;
import org.telegram.telegrambots.meta.api.objects.MessageId;

public class ForwardMessagesMethod implements
        ChatMessageThreadMethod<ForwardMessagesMethod, ArrayList<MessageId>>,
        NotificationMethod<ForwardMessagesMethod, ArrayList<MessageId>>,
        ProtectedContentMethod<ForwardMessagesMethod, ArrayList<MessageId>> {

    private final ForwardMessages.ForwardMessagesBuilder<?, ?> method;

    public ForwardMessagesMethod() {
        this(ForwardMessages.builder());
    }

    public ForwardMessagesMethod(@NotNull ForwardMessages.ForwardMessagesBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public ForwardMessagesMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    public ForwardMessagesMethod setMessageThreadId(@NotNull Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    public String getFromChatId() {
        return method.build().getFromChatId();
    }

    public ForwardMessagesMethod setFromChatId(@NotNull String chatId) {
        method.fromChatId(chatId);
        return this;
    }

    public ForwardMessagesMethod setFromChatId(long chatId) {
        method.fromChatId(chatId);
        return this;
    }

    public List<Integer> getMessageIds() {
        return method.build().getMessageIds();
    }

    public ForwardMessagesMethod setMessageIds(@NotNull List<Integer> messageIds) {
        method.messageIds(messageIds);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public ForwardMessagesMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public ForwardMessagesMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public ForwardMessagesMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ArrayList<MessageId> call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ArrayList<MessageId>> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
