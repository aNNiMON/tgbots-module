package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.objects.MessageId;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class CopyMessageMethod implements
        ChatMessageMethod<CopyMessageMethod, MessageId>,
        ReplyMarkupSupportedMessageMethod<CopyMessageMethod, MessageId>,
        ProtectedContentMethod<CopyMessageMethod, MessageId> {

    private final CopyMessage.CopyMessageBuilder method;

    public CopyMessageMethod() {
        this(CopyMessage.builder());
    }

    public CopyMessageMethod(@NotNull CopyMessage.CopyMessageBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public CopyMessageMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public CopyMessageMethod setMessageId(@NotNull Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public CopyMessageMethod setMessageThreadId(@NotNull Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    public String getFromChatId() {
        return method.build().getFromChatId();
    }

    public CopyMessageMethod setFromChatId(@NotNull String chatId) {
        method.fromChatId(chatId);
        return this;
    }

    public CopyMessageMethod setFromChatId(long chatId) {
        method.fromChatId(chatId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public CopyMessageMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public CopyMessageMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public CopyMessageMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public CopyMessageMethod setReplyToMessageId(Integer replyToMessageId) {
        method.replyToMessageId(replyToMessageId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public CopyMessageMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public CopyMessageMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public CopyMessageMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public MessageId call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<MessageId> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
