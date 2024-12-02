package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionAboveMediaMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.SpoilerMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendPhotoMethod implements
        MediaMessageMethod<SendPhotoMethod, Message>,
        ParseModeMethod<SendPhotoMethod, Message>,
        CaptionMethod<SendPhotoMethod, Message>,
        SpoilerMethod<SendPhotoMethod, Message>,
        CaptionAboveMediaMethod<SendPhotoMethod, Message> {

    private final SendPhoto.SendPhotoBuilder<?, ?> method;

    public SendPhotoMethod() {
        this(SendPhoto.builder());
    }

    public SendPhotoMethod(@NotNull SendPhoto.SendPhotoBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendPhotoMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendPhotoMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendPhotoMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendPhotoMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendPhotoMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendPhotoMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendPhotoMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getPhoto();
    }

    @Override
    public SendPhotoMethod setFile(@NotNull InputFile file) {
        method.photo(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public SendPhotoMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public SendPhotoMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }
    
    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public SendPhotoMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendPhotoMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public Boolean getHasSpoiler() {
        return method.build().getHasSpoiler();
    }

    @Override
    public SendPhotoMethod setHasSpoiler(Boolean spoiler) {
        method.hasSpoiler(spoiler);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendPhotoMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendPhotoMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendPhotoMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getShowCaptionAboveMedia() {
        return method.build().getShowCaptionAboveMedia();
    }

    @Override
    public SendPhotoMethod setShowCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        method.showCaptionAboveMedia(showCaptionAboveMedia);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendPhotoMethod setAllowPaidBroadcast(Boolean flag) {
        method.allowPaidBroadcast(flag);
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