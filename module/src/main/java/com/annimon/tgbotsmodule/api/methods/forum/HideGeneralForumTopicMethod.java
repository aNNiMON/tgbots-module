package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.HideGeneralForumTopic;

public class HideGeneralForumTopicMethod implements ChatMethod<HideGeneralForumTopicMethod, Boolean> {

    private final HideGeneralForumTopic.HideGeneralForumTopicBuilder method;

    public HideGeneralForumTopicMethod() {
        this(HideGeneralForumTopic.builder());
    }

    public HideGeneralForumTopicMethod(@NotNull HideGeneralForumTopic.HideGeneralForumTopicBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public HideGeneralForumTopicMethod setChatId(@NotNull String chatId) {
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
