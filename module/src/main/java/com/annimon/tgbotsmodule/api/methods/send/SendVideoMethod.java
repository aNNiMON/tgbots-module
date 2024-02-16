package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.DurationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.SpoilerMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ThumbMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendVideoMethod implements
        MediaMessageMethod<SendVideoMethod, Message>,
        ParseModeMethod<SendVideoMethod, Message>,
        CaptionMethod<SendVideoMethod, Message>,
        DurationMethod<SendVideoMethod, Message>,
        ThumbMethod<SendVideoMethod, Message>,
        SpoilerMethod<SendVideoMethod, Message> {

    private final SendVideo method;

    public SendVideoMethod() {
        this(new SendVideo());
    }

    public SendVideoMethod(@NotNull SendVideo method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendVideoMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendVideoMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    @Override
    public SendVideoMethod setMessageThreadId(Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.getAllowSendingWithoutReply();
    }

    @Override
    public SendVideoMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.setAllowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendVideoMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendVideoMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendVideoMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getVideo();
    }

    @Override
    public SendVideoMethod setFile(@NotNull InputFile file) {
        method.setVideo(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.getParseMode();
    }

    @Override
    public SendVideoMethod setParseMode(String parseMode) {
        method.setParseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.getCaptionEntities();
    }

    @Override
    public SendVideoMethod setEntities(List<MessageEntity> entities) {
        method.setCaptionEntities(entities);
        return this;
    }
    
    @Override
    public String getCaption() {
        return method.getCaption();
    }

    @Override
    public SendVideoMethod setCaption(String caption) {
        method.setCaption(caption);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.getDuration();
    }

    @Override
    public SendVideoMethod setDuration(Integer duration) {
        method.setDuration(duration);
        return this;
    }

    @Override
    public InputFile getThumbnail() {
        return method.getThumbnail();
    }

    @Override
    public SendVideoMethod setThumbnail(InputFile thumb) {
        method.setThumbnail(thumb);
        return this;
    }

    public Integer getWidth() {
        return method.getWidth();
    }

    public SendVideoMethod setWidth(Integer width) {
        method.setWidth(width);
        return this;
    }

    public Integer getHeight() {
        return method.getHeight();
    }

    public SendVideoMethod setHeight(Integer height) {
        method.setHeight(height);
        return this;
    }

    public Boolean getSupportsStreaming() {
        return method.getSupportsStreaming();
    }

    public SendVideoMethod setSupportsStreaming(Boolean supportsStreaming) {
        method.setSupportsStreaming(supportsStreaming);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.getProtectContent();
    }

    @Override
    public SendVideoMethod setProtectContent(Boolean protectContent) {
        method.setProtectContent(protectContent);
        return this;
    }

    @Override
    public Boolean getHasSpoiler() {
        return method.getHasSpoiler();
    }

    @Override
    public SendVideoMethod setHasSpoiler(Boolean spoiler) {
        method.setHasSpoiler(spoiler);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.getReplyParameters();
    }

    @Override
    public SendVideoMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.setReplyParameters(replyParameters);
        return this;
    }

    @Override
    public Message call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Message> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer);
    }
}