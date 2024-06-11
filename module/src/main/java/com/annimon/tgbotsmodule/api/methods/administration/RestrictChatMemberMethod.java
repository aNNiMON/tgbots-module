package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TimePeriodMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;

public class RestrictChatMemberMethod implements
        TimePeriodMethod<RestrictChatMemberMethod, Boolean>,
        ChatMemberMethod<RestrictChatMemberMethod, Boolean> {

    private final RestrictChatMember.RestrictChatMemberBuilder method;

    public RestrictChatMemberMethod() {
        this(RestrictChatMember.builder());
    }

    public RestrictChatMemberMethod(@NotNull RestrictChatMember.RestrictChatMemberBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public RestrictChatMemberMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public RestrictChatMemberMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public Integer getUntilDateInSeconds() {
        return method.build().getUntilDate();
    }

    @Override
    public RestrictChatMemberMethod setUntilDateInSeconds(Integer untilDate) {
        method.untilDate(untilDate);
        return this;
    }

    public Boolean getUseIndependentChatPermissions() {
        return method.build().getUseIndependentChatPermissions();
    }

    public RestrictChatMemberMethod setUseIndependentChatPermissions(Boolean flag) {
        method.useIndependentChatPermissions(flag);
        return this;
    }

    public ChatPermissions getPermissions() {
        return method.build().getPermissions();
    }

    public RestrictChatMemberMethod setPermissions(@NotNull ChatPermissions permissions) {
        method.permissions(permissions);
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
