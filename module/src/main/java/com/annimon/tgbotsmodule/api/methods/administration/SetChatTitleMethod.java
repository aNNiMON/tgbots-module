package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatTitle;

public class SetChatTitleMethod implements ChatMethod<SetChatTitleMethod, Boolean> {

    private final SetChatTitle.SetChatTitleBuilder method;

    public SetChatTitleMethod() {
        this(SetChatTitle.builder());
    }

    public SetChatTitleMethod(@NotNull SetChatTitle.SetChatTitleBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetChatTitleMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getTitle() {
        return method.build().getTitle();
    }

    public SetChatTitleMethod setTitle(@NotNull String title) {
        method.title(title);
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
