package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TimePeriodMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.BanChatSenderChat;

public class BanChatSenderChatMethod implements
        TimePeriodMethod<BanChatSenderChatMethod, Boolean>,
        ChatMethod<BanChatSenderChatMethod, Boolean> {

    private final BanChatSenderChat.BanChatSenderChatBuilder method;

    public BanChatSenderChatMethod() {
        this(BanChatSenderChat.builder());
    }

    public BanChatSenderChatMethod(@NotNull BanChatSenderChat.BanChatSenderChatBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public BanChatSenderChatMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public Long getSenderChatId() {
        return method.build().getSenderChatId();
    }

    public BanChatSenderChatMethod setSenderChatId(@NotNull Long senderChatId) {
        method.senderChatId(senderChatId);
        return this;
    }

    @Override
    public Integer getUntilDateInSeconds() {
        return method.build().getUntilDate();
    }

    @Override
    public BanChatSenderChatMethod setUntilDateInSeconds(Integer untilDate) {
        method.untilDate(untilDate);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
