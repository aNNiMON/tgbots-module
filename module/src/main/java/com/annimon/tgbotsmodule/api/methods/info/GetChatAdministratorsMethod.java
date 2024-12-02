package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatAdministrators;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;

public class GetChatAdministratorsMethod implements
        ChatMethod<GetChatAdministratorsMethod, ArrayList<ChatMember>> {

    private final GetChatAdministrators.GetChatAdministratorsBuilder<?, ?> method;

    public GetChatAdministratorsMethod() {
        this(GetChatAdministrators.builder());
    }

    public GetChatAdministratorsMethod(@NotNull GetChatAdministrators.GetChatAdministratorsBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public GetChatAdministratorsMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public ArrayList<ChatMember> call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ArrayList<ChatMember>> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
