package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TimePeriodMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class KickChatMemberMethod implements
        TimePeriodMethod<KickChatMemberMethod, Boolean>,
        ChatMemberMethod<KickChatMemberMethod, Boolean> {

    private final KickChatMember method;

    public KickChatMemberMethod() {
        this(new KickChatMember());
    }

    public KickChatMemberMethod(@NotNull KickChatMember method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public KickChatMemberMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public KickChatMemberMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public Integer getUntilDateInSeconds() {
        return method.getUntilDate();
    }

    @Override
    public KickChatMemberMethod setUntilDateInSeconds(Integer untilDate) {
        method.setUntilDate(untilDate);
        return this;
    }

    public Boolean getRevokeMessages() {
        return method.getRevokeMessages();
    }

    public KickChatMemberMethod setRevokeMessages(Boolean revokeMessages) {
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
