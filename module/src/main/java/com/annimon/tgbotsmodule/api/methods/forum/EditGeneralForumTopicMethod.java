package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.forum.EditGeneralForumTopic;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditGeneralForumTopicMethod implements ChatMethod<EditGeneralForumTopicMethod, Boolean> {

    private final EditGeneralForumTopic method;

    public EditGeneralForumTopicMethod() {
        this(new EditGeneralForumTopic());
    }

    public EditGeneralForumTopicMethod(@NotNull EditGeneralForumTopic method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public EditGeneralForumTopicMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public String getName() {
        return method.getName();
    }

    public EditGeneralForumTopicMethod setName(String name) {
        method.setName(name);
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
