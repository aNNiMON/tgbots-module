package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.UnhideGeneralForumTopic;

public class UnhideGeneralForumTopicMethod implements ChatMethod<UnhideGeneralForumTopicMethod, Boolean> {

    private final UnhideGeneralForumTopic.UnhideGeneralForumTopicBuilder method;

    public UnhideGeneralForumTopicMethod() {
        this(UnhideGeneralForumTopic.builder());
    }

    public UnhideGeneralForumTopicMethod(@NotNull UnhideGeneralForumTopic.UnhideGeneralForumTopicBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public UnhideGeneralForumTopicMethod setChatId(@NotNull String chatId) {
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
