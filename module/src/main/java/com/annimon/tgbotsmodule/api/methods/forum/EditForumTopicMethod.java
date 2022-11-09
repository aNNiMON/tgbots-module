package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageThreadMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.forum.EditForumTopic;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditForumTopicMethod implements ChatMessageThreadMethod<EditForumTopicMethod, Boolean> {

    private final EditForumTopic method;

    public EditForumTopicMethod() {
        this(new EditForumTopic());
    }

    public EditForumTopicMethod(@NotNull EditForumTopic method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public EditForumTopicMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    @Override
    public EditForumTopicMethod setMessageThreadId(Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
        return this;
    }

    public String getName() {
        return method.getName();
    }

    public EditForumTopicMethod setName(String name) {
        method.setName(name);
        return this;
    }

    public String getIconCustomEmojiId() {
        return method.getIconCustomEmojiId();
    }

    public EditForumTopicMethod setIconCustomEmojiId(String iconCustomEmojiId) {
        method.setIconCustomEmojiId(iconCustomEmojiId);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Boolean> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
