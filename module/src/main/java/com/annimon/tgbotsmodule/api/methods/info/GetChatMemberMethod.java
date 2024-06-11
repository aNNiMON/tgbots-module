package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;

public class GetChatMemberMethod implements ChatMemberMethod<GetChatMemberMethod, ChatMember> {

    private final GetChatMember.GetChatMemberBuilder method;

    public GetChatMemberMethod() {
        this(GetChatMember.builder());
    }

    public GetChatMemberMethod(@NotNull GetChatMember.GetChatMemberBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public GetChatMemberMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public GetChatMemberMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public ChatMember call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ChatMember> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
