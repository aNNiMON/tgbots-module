package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMemberCount;

public class GetChatMemberCountMethod implements ChatMethod<GetChatMemberCountMethod, Integer> {

    private final GetChatMemberCount.GetChatMemberCountBuilder method;

    public GetChatMemberCountMethod() {
        this(GetChatMemberCount.builder());
    }

    public GetChatMemberCountMethod(@NotNull GetChatMemberCount.GetChatMemberCountBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public GetChatMemberCountMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Integer> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
