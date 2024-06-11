package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.CloseGeneralForumTopic;

public class CloseGeneralForumTopicMethod implements ChatMethod<CloseGeneralForumTopicMethod, Boolean> {

    private final CloseGeneralForumTopic.CloseGeneralForumTopicBuilder method;

    public CloseGeneralForumTopicMethod() {
        this(CloseGeneralForumTopic.builder());
    }

    public CloseGeneralForumTopicMethod(@NotNull CloseGeneralForumTopic.CloseGeneralForumTopicBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public CloseGeneralForumTopicMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
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
