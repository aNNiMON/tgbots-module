package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TimePeriodMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.BanChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BanChatMemberMethod implements
        TimePeriodMethod<BanChatMemberMethod, Boolean>,
        ChatMemberMethod<BanChatMemberMethod, Boolean> {

    private final BanChatMember method;

    public BanChatMemberMethod() {
        this(new BanChatMember());
    }

    public BanChatMemberMethod(@NotNull BanChatMember method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public BanChatMemberMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public BanChatMemberMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public Integer getUntilDateInSeconds() {
        return method.getUntilDate();
    }

    @Override
    public BanChatMemberMethod setUntilDateInSeconds(Integer untilDate) {
        method.setUntilDate(untilDate);
        return this;
    }

    public Boolean getRevokeMessages() {
        return method.getRevokeMessages();
    }

    public BanChatMemberMethod setRevokeMessages(Boolean revokeMessages) {
        method.setRevokeMessages(revokeMessages);
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
