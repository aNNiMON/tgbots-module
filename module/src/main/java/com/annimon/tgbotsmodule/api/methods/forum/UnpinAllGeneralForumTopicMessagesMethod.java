package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.UnpinAllGeneralForumTopicMessages;

public class UnpinAllGeneralForumTopicMessagesMethod implements ChatMethod<UnpinAllGeneralForumTopicMessagesMethod, Boolean> {

    private final UnpinAllGeneralForumTopicMessages.UnpinAllGeneralForumTopicMessagesBuilder<?, ?> method;

    public UnpinAllGeneralForumTopicMessagesMethod() {
        this(UnpinAllGeneralForumTopicMessages.builder());
    }

    public UnpinAllGeneralForumTopicMessagesMethod(@NotNull UnpinAllGeneralForumTopicMessages.UnpinAllGeneralForumTopicMessagesBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public UnpinAllGeneralForumTopicMessagesMethod setChatId(@NotNull String chatId) {
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
