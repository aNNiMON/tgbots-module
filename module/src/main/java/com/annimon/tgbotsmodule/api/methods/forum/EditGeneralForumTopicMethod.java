package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.EditGeneralForumTopic;

public class EditGeneralForumTopicMethod implements ChatMethod<EditGeneralForumTopicMethod, Boolean> {

    private final EditGeneralForumTopic.EditGeneralForumTopicBuilder method;

    public EditGeneralForumTopicMethod() {
        this(EditGeneralForumTopic.builder());
    }

    public EditGeneralForumTopicMethod(@NotNull EditGeneralForumTopic.EditGeneralForumTopicBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditGeneralForumTopicMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public EditGeneralForumTopicMethod setName(String name) {
        method.name(name);
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
