package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.forum.UnpinAllGeneralForumTopicMessages;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UnpinAllGeneralForumTopicMessagesMethod implements ChatMethod<UnpinAllGeneralForumTopicMessagesMethod, Boolean> {

    private final UnpinAllGeneralForumTopicMessages method;

    public UnpinAllGeneralForumTopicMessagesMethod() {
        this(new UnpinAllGeneralForumTopicMessages());
    }

    public UnpinAllGeneralForumTopicMessagesMethod(@NotNull UnpinAllGeneralForumTopicMessages method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public UnpinAllGeneralForumTopicMessagesMethod setChatId(@NotNull String chatId) {
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
