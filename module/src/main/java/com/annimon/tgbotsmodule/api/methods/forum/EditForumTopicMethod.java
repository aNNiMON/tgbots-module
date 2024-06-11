package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageThreadMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.EditForumTopic;

public class EditForumTopicMethod implements ChatMessageThreadMethod<EditForumTopicMethod, Boolean> {

    private final EditForumTopic.EditForumTopicBuilder method;

    public EditForumTopicMethod() {
        this(EditForumTopic.builder());
    }

    public EditForumTopicMethod(@NotNull EditForumTopic.EditForumTopicBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditForumTopicMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public EditForumTopicMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public EditForumTopicMethod setName(String name) {
        method.name(name);
        return this;
    }

    public String getIconCustomEmojiId() {
        return method.build().getIconCustomEmojiId();
    }

    public EditForumTopicMethod setIconCustomEmojiId(String iconCustomEmojiId) {
        method.iconCustomEmojiId(iconCustomEmojiId);
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
