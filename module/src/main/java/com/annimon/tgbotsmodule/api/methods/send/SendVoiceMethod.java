package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.DurationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.suggestedpost.SuggestedPostParameters;

public class SendVoiceMethod implements
        MediaMessageMethod<SendVoiceMethod, Message>,
        ParseModeMethod<SendVoiceMethod, Message>,
        CaptionMethod<SendVoiceMethod, Message>,
        DurationMethod<SendVoiceMethod, Message> {

    private final SendVoice.SendVoiceBuilder<?, ?> method;

    public SendVoiceMethod() {
        this(SendVoice.builder());
    }

    public SendVoiceMethod(@NotNull SendVoice.SendVoiceBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendVoiceMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendVoiceMethod setReplyToMessageId(@NotNull Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendVoiceMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendVoiceMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendVoiceMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendVoiceMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendVoiceMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getVoice();
    }

    @Override
    public SendVoiceMethod setFile(@NotNull InputFile file) {
        method.voice(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public SendVoiceMethod setParseMode(@Nullable String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public SendVoiceMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }

    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public SendVoiceMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.build().getDuration();
    }

    @Override
    public SendVoiceMethod setDuration(Integer duration) {
        method.duration(duration);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendVoiceMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendVoiceMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendVoiceMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendVoiceMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendVoiceMethod setAllowPaidBroadcast(Boolean flag) {
        method.allowPaidBroadcast(flag);
        return this;
    }

    @Override
    public Integer getDirectMessagesTopicId() {
        return method.build().getDirectMessagesTopicId();
    }

    @Override
    public SendVoiceMethod setDirectMessagesTopicId(Integer topicId) {
        method.directMessagesTopicId(topicId);
        return this;
    }

    @Override
    public SuggestedPostParameters getSuggestedPostParameters() {
        return method.build().getSuggestedPostParameters();
    }

    @Override
    public SendVoiceMethod setSuggestedPostParameters(SuggestedPostParameters parameters) {
        method.suggestedPostParameters(parameters);
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