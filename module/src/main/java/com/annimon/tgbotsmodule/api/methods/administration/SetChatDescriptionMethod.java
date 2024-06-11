package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatDescription;

public class SetChatDescriptionMethod implements ChatMethod<SetChatDescriptionMethod, Boolean> {

    private final SetChatDescription.SetChatDescriptionBuilder method;

    public SetChatDescriptionMethod() {
        this(SetChatDescription.builder());
    }

    public SetChatDescriptionMethod(@NotNull SetChatDescription.SetChatDescriptionBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetChatDescriptionMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getDescription() {
        return method.build().getDescription();
    }

    public SetChatDescriptionMethod setDescription(@NotNull String description) {
        method.description(description);
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
