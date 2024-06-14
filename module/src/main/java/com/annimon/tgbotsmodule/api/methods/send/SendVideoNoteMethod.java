package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.DurationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ThumbMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendVideoNote;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendVideoNoteMethod implements
        MediaMessageMethod<SendVideoNoteMethod, Message>,
        DurationMethod<SendVideoNoteMethod, Message>,
        ThumbMethod<SendVideoNoteMethod, Message> {

    private final SendVideoNote.SendVideoNoteBuilder method;

    public SendVideoNoteMethod() {
        this(SendVideoNote.builder());
    }

    public SendVideoNoteMethod(@NotNull SendVideoNote.SendVideoNoteBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendVideoNoteMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendVideoNoteMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendVideoNoteMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendVideoNoteMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendVideoNoteMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendVideoNoteMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendVideoNoteMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getVideoNote();
    }

    @Override
    public SendVideoNoteMethod setFile(@NotNull InputFile file) {
        method.videoNote(file);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.build().getDuration();
    }

    @Override
    public SendVideoNoteMethod setDuration(Integer duration) {
        method.duration(duration);
        return this;
    }

    @Override
    public InputFile getThumbnail() {
        return method.build().getThumbnail();
    }

    @Override
    public SendVideoNoteMethod setThumbnail(InputFile thumb) {
        method.thumbnail(thumb);
        return this;
    }

    public Integer getLength() {
        return method.build().getLength();
    }

    public SendVideoNoteMethod setLength(Integer length) {
        method.length(length);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendVideoNoteMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendVideoNoteMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendVideoNoteMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendVideoNoteMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
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