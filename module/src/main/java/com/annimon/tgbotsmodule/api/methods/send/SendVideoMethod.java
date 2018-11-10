package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.DurationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ThumbMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.InputStream;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendVideoMethod implements
        MediaMessageMethod<SendVideoMethod, Message>,
        ParseModeMethod<SendVideoMethod, Message>,
        CaptionMethod<SendVideoMethod, Message>,
        DurationMethod<SendVideoMethod, Message>,
        ThumbMethod<SendVideoMethod, Message> {

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
    public SendVideoMethod setFile(@NotNull String fileId) {
        method.setVideo(fileId);
        return this;
    }

    @Override
    public SendVideoMethod setFile(@NotNull java.io.File file) {
        method.setVideo(file);
        return this;
    }

    @Override
    public SendVideoMethod setFile(@NotNull String name, @NotNull InputStream inputStream) {
        method.setVideo(name, inputStream);
        return this;
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
    public InputFile getThumb() {
        return method.getThumb();
    }

    @Override
    public SendVideoMethod setThumb(InputFile thumb) {
        method.setThumb(thumb);
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