package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.menubutton.SetChatMenuButton;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetChatMenuButtonMethod implements ChatMethod<SetChatMenuButtonMethod, Boolean> {

    private final SetChatMenuButton method;

    public SetChatMenuButtonMethod() {
        this(new SetChatMenuButton());
    }

    public SetChatMenuButtonMethod(@NotNull SetChatMenuButton method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SetChatMenuButtonMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public MenuButton getMenuButton() {
        return method.getMenuButton();
    }

    public SetChatMenuButtonMethod setMenuButton(MenuButton menuButton) {
        method.setMenuButton(menuButton);
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