package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.UnbanChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UnbanChatMemberMethod implements ChatMemberMethod<UnbanChatMemberMethod, Boolean> {

    private final UnbanChatMember method;

    public UnbanChatMemberMethod() {
        this(new UnbanChatMember());
    }

    public UnbanChatMemberMethod(@NotNull UnbanChatMember method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public UnbanChatMemberMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public UnbanChatMemberMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    public Boolean getOnlyIfBanned() {
        return method.getOnlyIfBanned();
    }

    public UnbanChatMemberMethod setOnlyIfBanned(Boolean onlyIfBanned) {
        method.setOnlyIfBanned(onlyIfBanned);
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
