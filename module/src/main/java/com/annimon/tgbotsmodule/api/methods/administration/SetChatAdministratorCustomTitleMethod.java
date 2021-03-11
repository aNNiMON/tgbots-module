package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatAdministratorCustomTitle;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetChatAdministratorCustomTitleMethod implements ChatMemberMethod<SetChatAdministratorCustomTitleMethod, Boolean> {

    private final SetChatAdministratorCustomTitle method;

    public SetChatAdministratorCustomTitleMethod() {
        this(new SetChatAdministratorCustomTitle());
    }

    public SetChatAdministratorCustomTitleMethod(@NotNull SetChatAdministratorCustomTitle method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SetChatAdministratorCustomTitleMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public SetChatAdministratorCustomTitleMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    public String getCustomTitle() {
        return method.getCustomTitle();
    }

    public SetChatAdministratorCustomTitleMethod setCustomTitle(String customTitle) {
        method.setCustomTitle(customTitle);
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
