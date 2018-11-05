package com.annimon.tgbotsmodule.api.methods.games;

import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.games.SetGameScore;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetGameScoreMethod implements
        InlineOrChatMessageMethod<SetGameScoreMethod, Serializable>,
        ChatMemberMethod<SetGameScoreMethod, Serializable> {

    private final SetGameScore method;

    public SetGameScoreMethod() {
        this(new SetGameScore());
    }

    public SetGameScoreMethod(@NotNull SetGameScore method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SetGameScoreMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        // Clear inline message id
        method.setInlineMessageId(null);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.getMessageId();
    }

    @Override
    public SetGameScoreMethod setMessageId(@NotNull Integer messageId) {
        method.setMessageId(messageId);
        // Clear inline message id
        method.setInlineMessageId(null);
        return this;
    }

    @Override
    public String getInlineMessageId() {
        return method.getInlineMessageId();
    }

    @Override
    public SetGameScoreMethod setInlineMessageId(@NotNull String inlineMessageId) {
        method.setInlineMessageId(inlineMessageId);
        // Clear chat id and message id
        method.setChatId((String) null);
        method.setMessageId(null);
        return this;
    }

    @Override
    public Integer getUserId() {
        return method.getUserId();
    }

    @Override
    public SetGameScoreMethod setUserId(@NotNull Integer userId) {
        method.setUserId(userId);
        return this;
    }

    public Integer getScore() {
        return method.getScore();
    }

    public SetGameScoreMethod setScore(@NotNull Integer score) {
        method.setScore(score);
        return this;
    }

    public Boolean getForce() {
        return method.getForce();
    }

    public SetGameScoreMethod setForce(Boolean force) {
        method.setForce(force);
        return this;
    }

    public Boolean getDisableEditMessage() {
        return method.getDisableEditMessage();
    }

    public SetGameScoreMethod setDisableEditMessage(Boolean disableEditMessage) {
        method.setDisableEditMessage(disableEditMessage);
        return this;
    }

    @Override
    public Serializable execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Serializable> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
