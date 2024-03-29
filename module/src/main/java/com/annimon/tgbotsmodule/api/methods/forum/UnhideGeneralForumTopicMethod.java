package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.forum.UnhideGeneralForumTopic;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UnhideGeneralForumTopicMethod implements ChatMethod<UnhideGeneralForumTopicMethod, Boolean> {

    private final UnhideGeneralForumTopic method;

    public UnhideGeneralForumTopicMethod() {
        this(new UnhideGeneralForumTopic());
    }

    public UnhideGeneralForumTopicMethod(@NotNull UnhideGeneralForumTopic method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public UnhideGeneralForumTopicMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
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
