package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.menubutton.SetChatMenuButton;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButton;

public class SetChatMenuButtonMethod implements ChatMethod<SetChatMenuButtonMethod, Boolean> {

    private final SetChatMenuButton.SetChatMenuButtonBuilder method;

    public SetChatMenuButtonMethod() {
        this(SetChatMenuButton.builder());
    }

    public SetChatMenuButtonMethod(@NotNull SetChatMenuButton.SetChatMenuButtonBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetChatMenuButtonMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public MenuButton getMenuButton() {
        return method.build().getMenuButton();
    }

    public SetChatMenuButtonMethod setMenuButton(MenuButton menuButton) {
        method.menuButton(menuButton);
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