package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TimePeriodMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.BanChatSenderChat;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BanChatSenderChatMethod implements
        TimePeriodMethod<BanChatSenderChatMethod, Boolean>,
        ChatMethod<BanChatSenderChatMethod, Boolean> {

    private final BanChatSenderChat method;

    public BanChatSenderChatMethod() {
        this(new BanChatSenderChat());
    }

    public BanChatSenderChatMethod(@NotNull BanChatSenderChat method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public BanChatSenderChatMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public Long getSenderChatId() {
        return method.getSenderChatId();
    }

    public BanChatSenderChatMethod setSenderChatId(@NotNull Long senderChatId) {
        method.setSenderChatId(senderChatId);
        return this;
    }

    @Override
    public Integer getUntilDateInSeconds() {
        return method.getUntilDate();
    }

    @Override
    public BanChatSenderChatMethod setUntilDateInSeconds(Integer untilDate) {
        method.setUntilDate(untilDate);
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
