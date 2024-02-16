package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.polls.SendPollMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendStickerMethod implements
        MediaMessageMethod<SendStickerMethod, Message> {

    private final SendSticker method;

    public SendStickerMethod() {
        this(new SendSticker());
    }

    public SendStickerMethod(@NotNull SendSticker method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendStickerMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendStickerMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    @Override
    public SendStickerMethod setMessageThreadId(Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.getAllowSendingWithoutReply();
    }

    @Override
    public SendStickerMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.setAllowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendStickerMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendStickerMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendStickerMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getSticker();
    }

    @Override
    public SendStickerMethod setFile(@NotNull InputFile file) {
        method.setSticker(file);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.getProtectContent();
    }

    @Override
    public SendStickerMethod setProtectContent(Boolean protectContent) {
        method.setProtectContent(protectContent);
        return this;
    }

    public String getEmoji() {
        return method.getEmoji();
    }

    public SendStickerMethod setEmoji(@NotNull String emoji) {
        method.setEmoji(emoji);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.getReplyParameters();
    }

    @Override
    public SendStickerMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
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