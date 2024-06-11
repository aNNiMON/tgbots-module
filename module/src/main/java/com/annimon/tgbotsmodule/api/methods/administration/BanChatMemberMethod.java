package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TimePeriodMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.BanChatMember;

public class BanChatMemberMethod implements
        TimePeriodMethod<BanChatMemberMethod, Boolean>,
        ChatMemberMethod<BanChatMemberMethod, Boolean> {

    private final BanChatMember.BanChatMemberBuilder method;

    public BanChatMemberMethod() {
        this(BanChatMember.builder());
    }

    public BanChatMemberMethod(@NotNull BanChatMember.BanChatMemberBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public BanChatMemberMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public BanChatMemberMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public Integer getUntilDateInSeconds() {
        return method.build().getUntilDate();
    }

    @Override
    public BanChatMemberMethod setUntilDateInSeconds(Integer untilDate) {
        method.untilDate(untilDate);
        return this;
    }

    public Boolean getRevokeMessages() {
        return method.build().getRevokeMessages();
    }

    public BanChatMemberMethod setRevokeMessages(Boolean revokeMessages) {
        method.revokeMessages(revokeMessages);
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
