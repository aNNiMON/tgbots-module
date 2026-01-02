package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.verification.RemoveUserVerification;

public class RemoveUserVerificationMethod implements UserMethod<RemoveUserVerificationMethod, Boolean> {

    private final RemoveUserVerification.RemoveUserVerificationBuilder method;

    public RemoveUserVerificationMethod() {
        this(RemoveUserVerification.builder());
    }

    public RemoveUserVerificationMethod(@NotNull RemoveUserVerification.RemoveUserVerificationBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public RemoveUserVerificationMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
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
