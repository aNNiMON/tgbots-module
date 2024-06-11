package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.CreateForumTopic;
import org.telegram.telegrambots.meta.api.objects.forum.ForumTopic;

public class CreateForumTopicMethod implements ChatMethod<CreateForumTopicMethod, ForumTopic> {

    private final CreateForumTopic.CreateForumTopicBuilder method;

    public CreateForumTopicMethod() {
        this(CreateForumTopic.builder());
    }

    public CreateForumTopicMethod(@NotNull CreateForumTopic.CreateForumTopicBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public CreateForumTopicMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public CreateForumTopicMethod setName(String name) {
        method.name(name);
        return this;
    }

    public Integer getIconColor() {
        return method.build().getIconColor();
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
        method.iconColor(iconColor);
        return this;
    }

    public String getIconCustomEmojiId() {
        return method.build().getIconCustomEmojiId();
    }

    public CreateForumTopicMethod setIconCustomEmojiId(String iconCustomEmojiId) {
        method.iconCustomEmojiId(iconCustomEmojiId);
        return this;
    }

    @Override
    public ForumTopic call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ForumTopic> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
