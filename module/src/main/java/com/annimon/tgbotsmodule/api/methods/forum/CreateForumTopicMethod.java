package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.forum.CreateForumTopic;
import org.telegram.telegrambots.meta.api.objects.forum.ForumTopic;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CreateForumTopicMethod implements ChatMethod<CreateForumTopicMethod, ForumTopic> {

    private final CreateForumTopic method;

    public CreateForumTopicMethod() {
        this(new CreateForumTopic());
    }

    public CreateForumTopicMethod(@NotNull CreateForumTopic method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public CreateForumTopicMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public String getName() {
        return method.getName();
    }

    public CreateForumTopicMethod setName(String name) {
        method.setName(name);
        return this;
    }

    public Integer getIconColor() {
        return method.getIconColor();
    }

    /**
     * Color of the topic icon in RGB format.
     *
     * Must be one of 0x6FB9F0, 0xFFD67E, 0xCB86DB, 0x8EEE98, 0xFF93B2, or 0xFB6F5F
     *
     * @param iconColor  the topic icon color
     * @return {@code CreateForumTopicMethod} instance
     */
    public CreateForumTopicMethod setIconColor(Integer iconColor) {
        method.setIconColor(iconColor);
        return this;
    }

    public String getIconCustomEmojiId() {
        return method.getIconCustomEmojiId();
    }

    public CreateForumTopicMethod setIconCustomEmojiId(String iconCustomEmojiId) {
        method.setIconCustomEmojiId(iconCustomEmojiId);
        return this;
    }

    @Override
    public ForumTopic call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super ForumTopic> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
