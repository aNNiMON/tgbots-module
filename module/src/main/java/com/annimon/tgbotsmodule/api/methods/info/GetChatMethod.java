package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.meta.api.objects.chat.ChatFullInfo;

public class GetChatMethod implements ChatMethod<GetChatMethod, ChatFullInfo> {

    private final GetChat.GetChatBuilder method;

    public GetChatMethod() {
        this(GetChat.builder());
    }

    public GetChatMethod(@NotNull GetChat.GetChatBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public GetChatMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public ChatFullInfo call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ChatFullInfo> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
