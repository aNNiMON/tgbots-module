package com.annimon.tgbotsmodule.api.methods.games;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.games.SetGameScore;

public class SetGameScoreMethod implements
        InlineOrChatMessageMethod<SetGameScoreMethod, Serializable>,
        ChatMemberMethod<SetGameScoreMethod, Serializable> {

    private final SetGameScore.SetGameScoreBuilder method;

    public SetGameScoreMethod() {
        this(SetGameScore.builder());
    }

    public SetGameScoreMethod(@NotNull SetGameScore.SetGameScoreBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetGameScoreMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        // Clear inline message id
        method.inlineMessageId(null);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public SetGameScoreMethod setMessageId(@NotNull Integer messageId) {
        method.messageId(messageId);
        // Clear inline message id
        method.inlineMessageId(null);
        return this;
    }

    @Override
    public String getInlineMessageId() {
        return method.build().getInlineMessageId();
    }

    @Override
    public SetGameScoreMethod setInlineMessageId(@NotNull String inlineMessageId) {
        method.inlineMessageId(inlineMessageId);
        // Clear chat id and message id
        method.chatId((String) null);
        method.messageId(null);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public SetGameScoreMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public Integer getScore() {
        return method.build().getScore();
    }

    public SetGameScoreMethod setScore(@NotNull Integer score) {
        method.score(score);
        return this;
    }

    public Boolean getForce() {
        return method.build().getForce();
    }

    public SetGameScoreMethod setForce(Boolean force) {
        method.force(force);
        return this;
    }

    public Boolean getDisableEditMessage() {
        return method.build().getDisableEditMessage();
    }

    public SetGameScoreMethod setDisableEditMessage(Boolean disableEditMessage) {
        method.disableEditMessage(disableEditMessage);
        return this;
    }

    @Override
    public Serializable call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Serializable> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
