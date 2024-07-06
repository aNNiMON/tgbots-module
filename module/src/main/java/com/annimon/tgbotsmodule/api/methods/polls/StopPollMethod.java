package com.annimon.tgbotsmodule.api.methods.polls;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.polls.StopPoll;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;

public class StopPollMethod implements
        ChatMessageMethod<StopPollMethod, Poll>,
        BusinessConnectionMethod<StopPollMethod, Poll> {

    private final StopPoll.StopPollBuilder method;

    public StopPollMethod() {
        this(StopPoll.builder());
    }

    public StopPollMethod(@NotNull StopPoll.StopPollBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public StopPollMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public StopPollMethod setMessageId(Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public StopPollMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Poll call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Poll> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
