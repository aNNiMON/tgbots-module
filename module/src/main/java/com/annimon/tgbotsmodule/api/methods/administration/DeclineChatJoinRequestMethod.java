package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.DeclineChatJoinRequest;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeclineChatJoinRequestMethod implements ChatMemberMethod<DeclineChatJoinRequestMethod, Boolean> {

    private final DeclineChatJoinRequest method;

    public DeclineChatJoinRequestMethod() {
        this(new DeclineChatJoinRequest());
    }

    public DeclineChatJoinRequestMethod(@NotNull DeclineChatJoinRequest method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public DeclineChatJoinRequestMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public DeclineChatJoinRequestMethod setUserId(@NotNull Long userId) {
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
