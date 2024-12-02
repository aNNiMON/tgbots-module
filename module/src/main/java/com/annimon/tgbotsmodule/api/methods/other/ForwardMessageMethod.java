package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageThreadMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public class ForwardMessageMethod implements
        ChatMessageMethod<ForwardMessageMethod, Message>,
        ChatMessageThreadMethod<ForwardMessageMethod, Message>,
        NotificationMethod<ForwardMessageMethod, Message>,
        ProtectedContentMethod<ForwardMessageMethod, Message> {

    private final ForwardMessage.ForwardMessageBuilder<?, ?> method;

    public ForwardMessageMethod() {
        this(ForwardMessage.builder());
    }

    public ForwardMessageMethod(@NotNull ForwardMessage.ForwardMessageBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public ForwardMessageMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public ForwardMessageMethod setMessageId(@NotNull Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public ForwardMessageMethod setMessageThreadId(@NotNull Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    public String getFromChatId() {
        return method.build().getFromChatId();
    }

    public ForwardMessageMethod setFromChatId(@NotNull String chatId) {
        method.fromChatId(chatId);
        return this;
    }

    public ForwardMessageMethod setFromChatId(long chatId) {
        method.fromChatId(chatId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public ForwardMessageMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public ForwardMessageMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public ForwardMessageMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public Message call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Message> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
