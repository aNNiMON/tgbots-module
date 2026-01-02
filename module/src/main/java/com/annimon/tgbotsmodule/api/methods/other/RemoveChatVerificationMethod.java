package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.verification.RemoveChatVerification;

public class RemoveChatVerificationMethod implements ChatMethod<RemoveChatVerificationMethod, Boolean> {

    private final RemoveChatVerification.RemoveChatVerificationBuilder method;

    public RemoveChatVerificationMethod() {
        this(RemoveChatVerification.builder());
    }

    public RemoveChatVerificationMethod(@NotNull RemoveChatVerification.RemoveChatVerificationBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public RemoveChatVerificationMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
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
