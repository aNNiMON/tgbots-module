package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.UnbanChatSenderChat;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UnbanChatSenderChatMethod implements ChatMethod<UnbanChatSenderChatMethod, Boolean> {

    private final UnbanChatSenderChat method;

    public UnbanChatSenderChatMethod() {
        this(new UnbanChatSenderChat());
    }

    public UnbanChatSenderChatMethod(@NotNull UnbanChatSenderChat method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public UnbanChatSenderChatMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public Long getSenderChatId() {
        return method.getSenderChatId();
    }

    public UnbanChatSenderChatMethod setSenderChatId(@NotNull Long senderChatId) {
        method.setSenderChatId(senderChatId);
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
