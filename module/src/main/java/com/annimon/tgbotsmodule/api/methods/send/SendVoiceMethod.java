package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.DurationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendVoiceMethod implements
        MediaMessageMethod<SendVoiceMethod, Message>,
        ParseModeMethod<SendVoiceMethod, Message>,
        CaptionMethod<SendVoiceMethod, Message>,
        DurationMethod<SendVoiceMethod, Message> {

    private final SendVoice method;

    public SendVoiceMethod() {
        this(new SendVoice());
    }

    public SendVoiceMethod(@NotNull SendVoice method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendVoiceMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendVoiceMethod setReplyToMessageId(@NotNull Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    @Override
    public SendVoiceMethod setMessageThreadId(Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.getAllowSendingWithoutReply();
    }

    @Override
    public SendVoiceMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.setAllowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendVoiceMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendVoiceMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendVoiceMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getVoice();
    }

    @Override
    public SendVoiceMethod setFile(@NotNull InputFile file) {
        method.setVoice(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.getParseMode();
    }

    @Override
    public SendVoiceMethod setParseMode(@Nullable String parseMode) {
        method.setParseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.getCaptionEntities();
    }

    @Override
    public SendVoiceMethod setEntities(List<MessageEntity> entities) {
        method.setCaptionEntities(entities);
        return this;
    }

    @Override
    public String getCaption() {
        return method.getCaption();
    }

    @Override
    public SendVoiceMethod setCaption(String caption) {
        method.setCaption(caption);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.getDuration();
    }

    @Override
    public SendVoiceMethod setDuration(Integer duration) {
        method.setDuration(duration);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.getProtectContent();
    }

    @Override
    public SendVoiceMethod setProtectContent(Boolean protectContent) {
        method.setProtectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.getReplyParameters();
    }

    @Override
    public SendVoiceMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
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