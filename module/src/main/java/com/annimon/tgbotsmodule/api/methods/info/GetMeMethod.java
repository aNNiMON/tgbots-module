package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.GetMe;
import org.telegram.telegrambots.meta.api.objects.User;

public class GetMeMethod implements Method<User> {

    private final GetMe.GetMeBuilder method;

    public GetMeMethod() {
        this(GetMe.builder());
    }

    public GetMeMethod(@NotNull GetMe.GetMeBuilder method) {
        this.method = method;
    }

    @Override
    public User call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<User> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}