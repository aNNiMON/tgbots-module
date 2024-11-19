package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionAboveMediaMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.DurationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.SpoilerMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ThumbMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendVideoMethod implements
        MediaMessageMethod<SendVideoMethod, Message>,
        ParseModeMethod<SendVideoMethod, Message>,
        CaptionMethod<SendVideoMethod, Message>,
        DurationMethod<SendVideoMethod, Message>,
        ThumbMethod<SendVideoMethod, Message>,
        SpoilerMethod<SendVideoMethod, Message>,
        CaptionAboveMediaMethod<SendVideoMethod, Message> {

    private final SendVideo.SendVideoBuilder method;

    public SendVideoMethod() {
        this(SendVideo.builder());
    }

    public SendVideoMethod(@NotNull SendVideo.SendVideoBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendVideoMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendVideoMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendVideoMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendVideoMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendVideoMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendVideoMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendVideoMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getVideo();
    }

    @Override
    public SendVideoMethod setFile(@NotNull InputFile file) {
        method.video(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public SendVideoMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public SendVideoMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }
    
    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public SendVideoMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.build().getDuration();
    }

    @Override
    public SendVideoMethod setDuration(Integer duration) {
        method.duration(duration);
        return this;
    }

    @Override
    public InputFile getThumbnail() {
        return method.build().getThumbnail();
    }

    @Override
    public SendVideoMethod setThumbnail(InputFile thumb) {
        method.thumbnail(thumb);
        return this;
    }

    public Integer getWidth() {
        return method.build().getWidth();
    }

    public SendVideoMethod setWidth(Integer width) {
        method.width(width);
        return this;
    }

    public Integer getHeight() {
        return method.build().getHeight();
    }

    public SendVideoMethod setHeight(Integer height) {
        method.height(height);
        return this;
    }

    public Boolean getSupportsStreaming() {
        return method.build().getSupportsStreaming();
    }

    public SendVideoMethod setSupportsStreaming(Boolean supportsStreaming) {
        method.supportsStreaming(supportsStreaming);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendVideoMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public Boolean getHasSpoiler() {
        return method.build().getHasSpoiler();
    }

    @Override
    public SendVideoMethod setHasSpoiler(Boolean spoiler) {
        method.hasSpoiler(spoiler);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendVideoMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendVideoMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendVideoMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getShowCaptionAboveMedia() {
        return method.build().getShowCaptionAboveMedia();
    }

    @Override
    public SendVideoMethod setShowCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        method.showCaptionAboveMedia(showCaptionAboveMedia);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendVideoMethod setAllowPaidBroadcast(Boolean flag) {
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