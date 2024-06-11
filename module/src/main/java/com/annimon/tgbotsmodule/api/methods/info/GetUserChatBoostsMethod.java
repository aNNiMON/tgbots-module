package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.boosts.GetUserChatBoosts;
import org.telegram.telegrambots.meta.api.objects.boost.UserChatBoosts;

public class GetUserChatBoostsMethod implements ChatMemberMethod<GetUserChatBoostsMethod, UserChatBoosts> {

    private final GetUserChatBoosts.GetUserChatBoostsBuilder method;

    public GetUserChatBoostsMethod() {
        this(GetUserChatBoosts.builder());
    }

    public GetUserChatBoostsMethod(@NotNull GetUserChatBoosts.GetUserChatBoostsBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public GetUserChatBoostsMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public GetUserChatBoostsMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public UserChatBoosts call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<UserChatBoosts> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
