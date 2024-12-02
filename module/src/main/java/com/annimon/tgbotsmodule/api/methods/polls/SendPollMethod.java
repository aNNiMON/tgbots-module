package com.annimon.tgbotsmodule.api.methods.polls;

import com.annimon.tgbotsmodule.api.methods.interfaces.AllowPaidBroadcastMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MessageEffectMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.polls.input.InputPollOption;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendPollMethod implements
        ReplyMarkupSupportedMessageMethod<SendPollMethod, Message>,
        ParseModeMethod<SendPollMethod, Message>,
        ProtectedContentMethod<SendPollMethod, Message>,
        AllowPaidBroadcastMethod<SendPollMethod, Message>,
        MessageEffectMethod<SendPollMethod, Message>,
        BusinessConnectionMethod<SendPollMethod, Message> {

    private final SendPoll.SendPollBuilder<?, ?> method;

    public SendPollMethod() {
        this(SendPoll.builder());
    }

    public SendPollMethod(@NotNull SendPoll.SendPollBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendPollMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendPollMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendPollMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendPollMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendPollMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendPollMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendPollMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getExplanationParseMode();
    }

    @Override
    public SendPollMethod setParseMode(String parseMode) {
        method.explanationParseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getExplanationEntities();
    }

    @Override
    public SendPollMethod setEntities(List<MessageEntity> entities) {
        method.explanationEntities(entities);
        return this;
    }

    public String getQuestion() {
        return method.build().getQuestion();
    }

    public SendPollMethod setQuestion(String question) {
        method.question(question);
        return this;
    }

    public List<InputPollOption> getOptions() {
        return method.build().getOptions();
    }

    public SendPollMethod setOptions(@NotNull List<InputPollOption> options) {
        method.options(options);
        return this;
    }

    public SendPollMethod setOptions(@NotNull InputPollOption option1) {
        return setOptions(List.of(option1));
    }

    public SendPollMethod setOptions(@NotNull InputPollOption option1, @NotNull InputPollOption option2) {
        return setOptions(List.of(option1, option2));
    }

    public SendPollMethod setOptions(@NotNull InputPollOption option1, @NotNull InputPollOption option2,
                                     @NotNull InputPollOption option3, @Nullable InputPollOption... rest) {
        final var options = new ArrayList<InputPollOption>(10);
        options.add(option1);
        options.add(option2);
        options.add(option3);
        if (rest != null) {
            options.addAll(List.of(rest));
        }
        return setOptions(options);
    }

    public Boolean getIsAnonymous() {
        return method.build().getIsAnonymous();
    }

    public SendPollMethod setIsAnonymous(boolean anonymous) {
        method.isAnonymous(anonymous);
        return this;
    }

    public String getType() {
        return method.build().getType();
    }

    public SendPollMethod setType(String type) {
        method.type(type);
        return this;
    }

    public Boolean getAllowMultipleAnswers() {
        return method.build().getAllowMultipleAnswers();
    }

    public SendPollMethod setAllowMultipleAnswers(boolean allowMultipleAnswers) {
        method.allowMultipleAnswers(allowMultipleAnswers);
        return this;
    }

    public Integer getCorrectOptionId() {
        return method.build().getCorrectOptionId();
    }

    public SendPollMethod setCorrectOptionId(Integer correctOptionId) {
        method.correctOptionId(correctOptionId);
        return this;
    }

    public Boolean getIsClosed() {
        return method.build().getIsClosed();
    }

    public SendPollMethod setIsClosed(boolean closed) {
        method.isClosed(closed);
        return this;
    }

    public Integer getOpenPeriod() {
        return method.build().getOpenPeriod();
    }

    public SendPollMethod setOpenPeriod(Integer openPeriod) {
        method.openPeriod(openPeriod);
        return this;
    }

    public Integer getCloseDate() {
        return method.build().getCloseDate();
    }

    public SendPollMethod setCloseDate(Integer closeDate) {
        method.closeDate(closeDate);
        return this;
    }

    public String getExplanation() {
        return method.build().getExplanation();
    }

    public SendPollMethod setExplanation(String explanation) {
        method.explanation(explanation);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendPollMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendPollMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendPollMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendPollMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public String getQuestionParseMode() {
        return method.build().getQuestionParseMode();
    }

    public SendPollMethod setQuestionParseMode(String parseMode) {
        method.questionParseMode(parseMode);
        return this;
    }

    public List<MessageEntity> getQuestionEntities() {
        return method.build().getQuestionEntities();
    }

    public SendPollMethod setQuestionEntities(List<MessageEntity> questionEntities) {
        method.questionEntities(questionEntities);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendPollMethod setAllowPaidBroadcast(Boolean flag) {
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
