package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.TimePeriodMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RestrictChatMemberMethod implements TimePeriodMethod<RestrictChatMemberMethod, Boolean> {

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
    public Integer getUserId() {
        return method.getUserId();
    }

    @Override
    public RestrictChatMemberMethod setUserId(@NotNull Integer userId) {
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

    public Boolean canSendMessages() {
        return method.getCanSendMessages();
    }

    public RestrictChatMemberMethod setCanSendMessages(Boolean canSendMessages) {
        method.setCanSendMessages(canSendMessages);
        return this;
    }

    public Boolean canSendMediaMessages() {
        return method.getCanSendMediaMessages();
    }

    public RestrictChatMemberMethod setCanSendMediaMessages(Boolean canSendMediaMessages) {
        method.setCanSendMediaMessages(canSendMediaMessages);
        return this;
    }

    public Boolean canSendOtherMessages() {
        return method.getCanSendOtherMessages();
    }

    public RestrictChatMemberMethod setCanSendOtherMessages(Boolean canSendOtherMessages) {
        method.setCanSendOtherMessages(canSendOtherMessages);
        return this;
    }

    public Boolean canAddWebPagePreviews() {
        return method.getCanAddWebPagePreviews();
    }

    public RestrictChatMemberMethod setCanAddWebPagePreviews(Boolean canAddWebPagePreviews) {
        method.setCanAddWebPagePreviews(canAddWebPagePreviews);
        return this;
    }

    @Override
    public Boolean execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Boolean> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
