package com.annimon.tgbotsmodule.api.methods.polls;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.polls.StopPoll;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StopPollMethod implements
        ChatMessageMethod<StopPollMethod, Poll> {

    private final StopPoll method;

    public StopPollMethod() {
        this(new StopPoll());
    }

    public StopPollMethod(@NotNull StopPoll method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public StopPollMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.getMessageId();
    }

    @Override
    public StopPollMethod setMessageId(Integer messageId) {
        method.setMessageId(messageId);
        return this;
    }

    @Override
    public Poll call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Poll> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
