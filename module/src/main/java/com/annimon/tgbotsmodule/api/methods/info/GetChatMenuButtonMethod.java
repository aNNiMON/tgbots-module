package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.menubutton.GetChatMenuButton;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButton;

public class GetChatMenuButtonMethod implements ChatMethod<GetChatMenuButtonMethod, MenuButton> {

    private final GetChatMenuButton.GetChatMenuButtonBuilder method;

    public GetChatMenuButtonMethod() {
        this(GetChatMenuButton.builder());
    }

    public GetChatMenuButtonMethod(@NotNull GetChatMenuButton.GetChatMenuButtonBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public GetChatMenuButtonMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public MenuButton call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<MenuButton> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
