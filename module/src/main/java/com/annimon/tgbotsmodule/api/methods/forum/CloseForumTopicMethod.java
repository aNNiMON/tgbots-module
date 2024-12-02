package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageThreadMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.CloseForumTopic;

public class CloseForumTopicMethod implements ChatMessageThreadMethod<CloseForumTopicMethod, Boolean> {

    private final CloseForumTopic.CloseForumTopicBuilder<?, ?> method;

    public CloseForumTopicMethod() {
        this(CloseForumTopic.builder());
    }

    public CloseForumTopicMethod(@NotNull CloseForumTopic.CloseForumTopicBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public CloseForumTopicMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public CloseForumTopicMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
