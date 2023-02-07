package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TimePeriodMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RestrictChatMemberMethod implements
        TimePeriodMethod<RestrictChatMemberMethod, Boolean>,
        ChatMemberMethod<RestrictChatMemberMethod, Boolean> {

    private final RestrictChatMember method;

    public RestrictChatMemberMethod() {
        this(new RestrictChatMember());
    }

    public RestrictChatMemberMethod(@NotNull RestrictChatMember method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public RestrictChatMemberMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public RestrictChatMemberMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public Integer getUntilDateInSeconds() {
        return method.getUntilDate();
    }

    @Override
    public RestrictChatMemberMethod setUntilDateInSeconds(Integer untilDate) {
        method.setUntilDate(untilDate);
        return this;
    }

    public Boolean getUseIndependentChatPermissions() {
        return method.getUseIndependentChatPermissions();
    }

    public RestrictChatMemberMethod setUseIndependentChatPermissions(Boolean flag) {
        method.setUseIndependentChatPermissions(flag);
        return this;
    }

    public ChatPermissions getPermissions() {
        return method.getPermissions();
    }

    public RestrictChatMemberMethod setPermissions(@NotNull ChatPermissions permissions) {
        method.setPermissions(permissions);
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
