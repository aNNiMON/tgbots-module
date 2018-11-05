package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.InputStream;
import java.util.Objects;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendPhotoMethod implements
        MediaMessageMethod<SendPhotoMethod, Message>,
        ParseModeMethod<SendPhotoMethod, Message>,
        CaptionMethod<SendPhotoMethod, Message> {

    private final SendPhoto method;

    public SendPhotoMethod() {
        this(new SendPhoto());
    }

    public SendPhotoMethod(@NotNull SendPhoto method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendPhotoMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendPhotoMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return !Objects.requireNonNullElse(method.getDisableNotification(), false);
    }

    @Override
    public SendPhotoMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendPhotoMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendPhotoMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getPhoto();
    }

    @Override
    public SendPhotoMethod setFile(@NotNull String fileId) {
        method.setPhoto(fileId);
        return this;
    }

    @Override
    public SendPhotoMethod setFile(@NotNull java.io.File file) {
        method.setPhoto(file);
        return this;
    }

    @Override
    public SendPhotoMethod setFile(@NotNull String name, @NotNull InputStream inputStream) {
        method.setPhoto(name, inputStream);
        return this;
    }

    @Override
    public SendPhotoMethod setFile(@NotNull InputFile file) {
        method.setPhoto(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.getParseMode();
    }

    @Override
    public SendPhotoMethod setParseMode(String parseMode) {
        method.setParseMode(parseMode);
        return this;
    }
    
    @Override
    public String getCaption() {
        return method.getCaption();
    }

    @Override
    public SendPhotoMethod setCaption(String caption) {
        method.setCaption(caption);
        return this;
    }

    @Override
    public Message execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Message> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer);
    }
}