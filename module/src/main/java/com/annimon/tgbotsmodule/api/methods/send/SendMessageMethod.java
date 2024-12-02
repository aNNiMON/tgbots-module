package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.AllowPaidBroadcastMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MessageEffectMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TextMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.WebPagePreviewMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.LinkPreviewOptions;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendMessageMethod implements
        ReplyMarkupSupportedMessageMethod<SendMessageMethod, Message>,
        ParseModeMethod<SendMessageMethod, Message>,
        WebPagePreviewMethod<SendMessageMethod, Message>,
        ProtectedContentMethod<SendMessageMethod, Message>,
        AllowPaidBroadcastMethod<SendMessageMethod, Message>,
        TextMethod<SendMessageMethod, Message>,
        MessageEffectMethod<SendMessageMethod, Message>,
        BusinessConnectionMethod<SendMessageMethod, Message> {

    private final SendMessage.SendMessageBuilder<?, ?> method;

    public SendMessageMethod() {
        this(SendMessage.builder());
    }

    public SendMessageMethod(@NotNull SendMessage.SendMessageBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendMessageMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendMessageMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendMessageMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendMessageMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendMessageMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendMessageMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendMessageMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendMessageMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public SendMessageMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getEntities();
    }

    @Override
    public SendMessageMethod setEntities(List<MessageEntity> entities) {
        method.build().setEntities(entities);
        return this;
    }

    @Override
    public String getText() {
        return method.build().getText();
    }

    @Override
    public SendMessageMethod setText(@NotNull String text) {
        method.text(text);
        return this;
    }

    @Override
    public boolean isWebPagePreviewDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableWebPagePreview());
    }

    public SendMessageMethod disableWebPagePreview() {
        method.disableWebPagePreview(true);
        return this;
    }

    public SendMessageMethod enableWebPagePreview() {
        method.disableWebPagePreview(false);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendMessageMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    public LinkPreviewOptions getLinkPreviewOptions() {
        return method.build().getLinkPreviewOptions();
    }

    public SendMessageMethod setLinkPreviewOptions(LinkPreviewOptions options) {
        method.linkPreviewOptions(options);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendMessageMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendMessageMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendMessageMethod setAllowPaidBroadcast(Boolean flag) {
        method.allowPaidBroadcast(flag);
        return this;
    }

    @Override
    public Message call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Message> callAsync(CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}