package com.annimon.tgbotsmodule.api.methods.games;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.games.GetGameHighScores;
import org.telegram.telegrambots.meta.api.objects.games.GameHighScore;

public class GetGameHighScoresMethod implements
        InlineOrChatMessageMethod<GetGameHighScoresMethod, ArrayList<GameHighScore>>,
        ChatMemberMethod<GetGameHighScoresMethod, ArrayList<GameHighScore>> {

    private final GetGameHighScores.GetGameHighScoresBuilder method;

    public GetGameHighScoresMethod() {
        this(GetGameHighScores.builder());
    }

    public GetGameHighScoresMethod(@NotNull GetGameHighScores.GetGameHighScoresBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public GetGameHighScoresMethod setChatId(@NotNull String chatId) {
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
    public GetGameHighScoresMethod setMessageId(@NotNull Integer messageId) {
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
    public GetGameHighScoresMethod setInlineMessageId(@NotNull String inlineMessageId) {
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
    public GetGameHighScoresMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public ArrayList<GameHighScore> call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ArrayList<GameHighScore>> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
