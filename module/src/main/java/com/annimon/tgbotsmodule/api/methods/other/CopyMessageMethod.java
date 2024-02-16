package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.objects.MessageId;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CopyMessageMethod implements
        ChatMessageMethod<CopyMessageMethod, MessageId>,
        ReplyMarkupSupportedMessageMethod<CopyMessageMethod, MessageId>,
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

    @Override
    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    @Override
    public CopyMessageMethod setMessageThreadId(@NotNull Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
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
        method.setFromChatId(chatId);
        return this;
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
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public CopyMessageMethod setReplyToMessageId(Integer replyToMessageId) {
        method.setReplyToMessageId(replyToMessageId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.getAllowSendingWithoutReply();
    }

    @Override
    public CopyMessageMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.setAllowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public CopyMessageMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.getReplyParameters();
    }

    @Override
    public CopyMessageMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.setReplyParameters(replyParameters);
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
