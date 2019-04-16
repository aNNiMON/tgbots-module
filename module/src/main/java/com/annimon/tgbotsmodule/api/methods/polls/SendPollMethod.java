package com.annimon.tgbotsmodule.api.methods.polls;

import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendPollMethod implements
        ReplyMarkupSupportedMessageMethod<SendPollMethod, Message> {

    private final SendPoll method;

    public SendPollMethod() {
        this(new SendPoll());
    }

    public SendPollMethod(@NotNull SendPoll method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendPollMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendPollMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendPollMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendPollMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendPollMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    public String getQuestion() {
        return method.getQuestion();
    }

    public SendPollMethod setQuestion(String question) {
        method.setQuestion(question);
        return this;
    }

    public List<String> getOptions() {
        return method.getOptions();
    }

    public SendPollMethod setOptions(@NotNull List<String> options) {
        method.setOptions(options);
        return this;
    }

    public SendPollMethod setOptions(@NotNull String option1) {
        return setOptions(List.of(option1));
    }

    public SendPollMethod setOptions(@NotNull String option1, @NotNull String option2) {
        return setOptions(List.of(option1, option2));
    }

    public SendPollMethod setOptions(@NotNull String option1, @NotNull String option2,
                                     @NotNull String option3, @Nullable String... rest) {
        final var options = new ArrayList<String>(10);
        options.add(option1);
        options.add(option2);
        options.add(option3);
        if (rest != null) {
            options.addAll(List.of(rest));
        }
        return setOptions(options);
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
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
