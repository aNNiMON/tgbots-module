package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageThreadMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.RemoveCaptionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.CopyMessages;
import org.telegram.telegrambots.meta.api.objects.MessageId;

public class CopyMessagesMethod implements
        ChatMessageThreadMethod<CopyMessagesMethod, ArrayList<MessageId>>,
        NotificationMethod<CopyMessagesMethod, ArrayList<MessageId>>,
        ProtectedContentMethod<CopyMessagesMethod, ArrayList<MessageId>>,
        RemoveCaptionMethod<CopyMessagesMethod, ArrayList<MessageId>> {

    private final CopyMessages.CopyMessagesBuilder<?, ?> method;

    public CopyMessagesMethod() {
        this(CopyMessages.builder());
    }

    public CopyMessagesMethod(@NotNull CopyMessages.CopyMessagesBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public CopyMessagesMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    public CopyMessagesMethod setMessageThreadId(@NotNull Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    public String getFromChatId() {
        return method.build().getFromChatId();
    }

    public CopyMessagesMethod setFromChatId(@NotNull String chatId) {
        method.fromChatId(chatId);
        return this;
    }

    public CopyMessagesMethod setFromChatId(long chatId) {
        method.fromChatId(chatId);
        return this;
    }

    public List<Integer> getMessageIds() {
        return method.build().getMessageIds();
    }

    public CopyMessagesMethod setMessageIds(@NotNull List<Integer> messageIds) {
        method.messageIds(messageIds);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public CopyMessagesMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public CopyMessagesMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public CopyMessagesMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public Boolean getRemoveCaption() {
        return method.build().getRemoveCaption();
    }

    @Override
    public CopyMessagesMethod setRemoveCaption(Boolean removeCaption) {
        method.removeCaption(removeCaption);
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
