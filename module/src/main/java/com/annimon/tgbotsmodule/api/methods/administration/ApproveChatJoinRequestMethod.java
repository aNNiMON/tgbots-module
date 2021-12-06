package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.ApproveChatJoinRequest;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ApproveChatJoinRequestMethod implements ChatMemberMethod<ApproveChatJoinRequestMethod, Boolean> {

    private final ApproveChatJoinRequest method;

    public ApproveChatJoinRequestMethod() {
        this(new ApproveChatJoinRequest());
    }

    public ApproveChatJoinRequestMethod(@NotNull ApproveChatJoinRequest method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public ApproveChatJoinRequestMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public ApproveChatJoinRequestMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
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
