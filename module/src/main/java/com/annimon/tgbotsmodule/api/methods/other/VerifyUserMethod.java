package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.verification.VerifyUser;

public class VerifyUserMethod implements UserMethod<VerifyUserMethod, Boolean> {

    private final VerifyUser.VerifyUserBuilder method;

    public VerifyUserMethod() {
        this(VerifyUser.builder());
    }

    public VerifyUserMethod(@NotNull VerifyUser.VerifyUserBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public VerifyUserMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public String customDescription() {
        return method.build().getCustomDescription();
    }

    public VerifyUserMethod setCustomDescription(String description) {
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
