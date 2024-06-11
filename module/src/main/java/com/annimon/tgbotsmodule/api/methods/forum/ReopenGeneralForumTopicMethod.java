package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.ReopenGeneralForumTopic;

public class ReopenGeneralForumTopicMethod implements ChatMethod<ReopenGeneralForumTopicMethod, Boolean> {

    private final ReopenGeneralForumTopic.ReopenGeneralForumTopicBuilder method;

    public ReopenGeneralForumTopicMethod() {
        this(ReopenGeneralForumTopic.builder());
    }

    public ReopenGeneralForumTopicMethod(@NotNull ReopenGeneralForumTopic.ReopenGeneralForumTopicBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public ReopenGeneralForumTopicMethod setChatId(@NotNull String chatId) {
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
