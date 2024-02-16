package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.DurationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ThumbMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendVideoNote;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendVideoNoteMethod implements
        MediaMessageMethod<SendVideoNoteMethod, Message>,
        DurationMethod<SendVideoNoteMethod, Message>,
        ThumbMethod<SendVideoNoteMethod, Message> {

    private final SendVideoNote method;

    public SendVideoNoteMethod() {
        this(new SendVideoNote());
    }

    public SendVideoNoteMethod(@NotNull SendVideoNote method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendVideoNoteMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendVideoNoteMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    @Override
    public SendVideoNoteMethod setMessageThreadId(Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.getAllowSendingWithoutReply();
    }

    @Override
    public SendVideoNoteMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.setAllowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendVideoNoteMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendVideoNoteMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendVideoNoteMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getVideoNote();
    }

    @Override
    public SendVideoNoteMethod setFile(@NotNull InputFile file) {
        method.setVideoNote(file);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.getDuration();
    }

    @Override
    public SendVideoNoteMethod setDuration(Integer duration) {
        method.setDuration(duration);
        return this;
    }

    @Override
    public InputFile getThumbnail() {
        return method.getThumbnail();
    }

    @Override
    public SendVideoNoteMethod setThumbnail(InputFile thumb) {
        method.setThumbnail(thumb);
        return this;
    }

    public Integer getLength() {
        return method.getLength();
    }

    public SendVideoNoteMethod setLength(Integer length) {
        method.setLength(length);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.getProtectContent();
    }

    @Override
    public SendVideoNoteMethod setProtectContent(Boolean protectContent) {
        method.setProtectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.getReplyParameters();
    }

    @Override
    public SendVideoNoteMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
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