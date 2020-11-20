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
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendAudioMethod implements
        MediaMessageMethod<SendAudioMethod, Message>,
        ParseModeMethod<SendAudioMethod, Message>,
        CaptionMethod<SendAudioMethod, Message>,
        DurationMethod<SendAudioMethod, Message>,
        ThumbMethod<SendAudioMethod, Message> {

    private final SendAudio method;

    public SendAudioMethod() {
        this(new SendAudio());
    }

    public SendAudioMethod(@NotNull SendAudio method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendAudioMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendAudioMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendAudioMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendAudioMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendAudioMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getAudio();
    }

    @Override
    public SendAudioMethod setFile(@NotNull InputFile file) {
        method.setAudio(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.getParseMode();
    }

    @Override
    public SendAudioMethod setParseMode(String parseMode) {
        method.setParseMode(parseMode);
        return this;
    }
    
    @Override
    public String getCaption() {
        return method.getCaption();
    }

    @Override
    public SendAudioMethod setCaption(String caption) {
        method.setCaption(caption);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.getDuration();
    }

    @Override
    public SendAudioMethod setDuration(@NotNull Integer duration) {
        method.setDuration(duration);
        return this;
    }

    @Override
    public InputFile getThumb() {
        return method.getThumb();
    }

    @Override
    public SendAudioMethod setThumb(@NotNull InputFile thumb) {
        method.setThumb(thumb);
        return this;
    }

    public String getPerformer() {
        return method.getPerformer();
    }

    public SendAudioMethod setPerformer(String performer) {
        method.setPerformer(performer);
        return this;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public SendAudioMethod setTitle(String title) {
        method.setTitle(title);
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