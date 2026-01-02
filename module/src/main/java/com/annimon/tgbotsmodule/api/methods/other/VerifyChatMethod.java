package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.verification.VerifyChat;

public class VerifyChatMethod implements ChatMethod<VerifyChatMethod, Boolean> {

    private final VerifyChat.VerifyChatBuilder method;

    public VerifyChatMethod() {
        this(VerifyChat.builder());
    }

    public VerifyChatMethod(@NotNull VerifyChat.VerifyChatBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public VerifyChatMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String customDescription() {
        return method.build().getCustomDescription();
    }

    public VerifyChatMethod setCustomDescription(String description) {
        method.customDescription(description);
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
