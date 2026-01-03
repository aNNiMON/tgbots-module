package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ThumbMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.suggestedpost.SuggestedPostParameters;

public class SendDocumentMethod implements
        MediaMessageMethod<SendDocumentMethod, Message>,
        ParseModeMethod<SendDocumentMethod, Message>,
        CaptionMethod<SendDocumentMethod, Message>,
        ThumbMethod<SendDocumentMethod, Message> {

    private final SendDocument.SendDocumentBuilder<?, ?> method;

    public SendDocumentMethod() {
        this(SendDocument.builder());
    }

    public SendDocumentMethod(@NotNull SendDocument.SendDocumentBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendDocumentMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendDocumentMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendDocumentMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendDocumentMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendDocumentMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendDocumentMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendDocumentMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getDocument();
    }

    @Override
    public SendDocumentMethod setFile(@NotNull InputFile file) {
        method.document(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public SendDocumentMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public SendDocumentMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }
    
    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public SendDocumentMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    @Override
    public InputFile getThumbnail() {
        return method.build().getThumbnail();
    }

    @Override
    public SendDocumentMethod setThumbnail(InputFile thumb) {
        method.thumbnail(thumb);
        return this;
    }

    public Boolean getDisableContentTypeDetection() {
        return method.build().getDisableContentTypeDetection();
    }

    public SendDocumentMethod setDisableNotification(Boolean disableNotification) {
        method.disableNotification(disableNotification);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendDocumentMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendDocumentMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendDocumentMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendDocumentMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendDocumentMethod setAllowPaidBroadcast(Boolean flag) {
        method.allowPaidBroadcast(flag);
        return this;
    }

    @Override
    public Integer getDirectMessagesTopicId() {
        return method.build().getDirectMessagesTopicId();
    }

    @Override
    public SendDocumentMethod setDirectMessagesTopicId(Integer topicId) {
        method.directMessagesTopicId(topicId);
        return this;
    }

    @Override
    public SuggestedPostParameters getSuggestedPostParameters() {
        return method.build().getSuggestedPostParameters();
    }

    @Override
    public SendDocumentMethod setSuggestedPostParameters(SuggestedPostParameters parameters) {
        method.suggestedPostParameters(parameters);
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