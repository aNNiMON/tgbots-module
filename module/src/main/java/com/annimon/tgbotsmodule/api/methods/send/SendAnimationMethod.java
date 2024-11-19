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
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendAnimationMethod implements
        MediaMessageMethod<SendAnimationMethod, Message>,
        ParseModeMethod<SendAnimationMethod, Message>,
        CaptionMethod<SendAnimationMethod, Message>,
        DurationMethod<SendAnimationMethod, Message>,
        ThumbMethod<SendAnimationMethod, Message>,
        SpoilerMethod<SendAnimationMethod, Message>,
        CaptionAboveMediaMethod<SendAnimationMethod, Message> {

    private final SendAnimation.SendAnimationBuilder method;

    public SendAnimationMethod() {
        this(SendAnimation.builder());
    }

    public SendAnimationMethod(@NotNull SendAnimation.SendAnimationBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendAnimationMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendAnimationMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendAnimationMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendAnimationMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendAnimationMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendAnimationMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendAnimationMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getAnimation();
    }

    @Override
    public SendAnimationMethod setFile(@NotNull InputFile file) {
        method.animation(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public SendAnimationMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public SendAnimationMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }
    
    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public SendAnimationMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.build().getDuration();
    }

    @Override
    public SendAnimationMethod setDuration(Integer duration) {
        method.duration(duration);
        return this;
    }

    @Override
    public InputFile getThumbnail() {
        return method.build().getThumbnail();
    }

    @Override
    public SendAnimationMethod setThumbnail(InputFile thumb) {
        method.thumbnail(thumb);
        return this;
    }

    public Integer getWidth() {
        return method.build().getWidth();
    }

    public SendAnimationMethod setWidth(Integer width) {
        method.width(width);
        return this;
    }

    public Integer getHeight() {
        return method.build().getHeight();
    }

    public SendAnimationMethod setHeight(Integer height) {
        method.height(height);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendAnimationMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public Boolean getHasSpoiler() {
        return method.build().getHasSpoiler();
    }

    @Override
    public SendAnimationMethod setHasSpoiler(Boolean spoiler) {
        method.hasSpoiler(spoiler);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendAnimationMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendAnimationMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public Boolean getShowCaptionAboveMedia() {
        return method.build().getShowCaptionAboveMedia();
    }

    @Override
    public SendAnimationMethod setShowCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        method.showCaptionAboveMedia(showCaptionAboveMedia);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendAnimationMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendAnimationMethod setAllowPaidBroadcast(Boolean flag) {
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