package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.forum.CloseGeneralForumTopic;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CloseGeneralForumTopicMethod implements ChatMethod<CloseGeneralForumTopicMethod, Boolean> {

    private final CloseGeneralForumTopic method;

    public CloseGeneralForumTopicMethod() {
        this(new CloseGeneralForumTopic());
    }

    public CloseGeneralForumTopicMethod(@NotNull CloseGeneralForumTopic method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public CloseGeneralForumTopicMethod setChatId(@NotNull String chatId) {
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
