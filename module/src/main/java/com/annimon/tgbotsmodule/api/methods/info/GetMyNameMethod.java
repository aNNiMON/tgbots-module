package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.name.GetMyName;
import org.telegram.telegrambots.meta.api.objects.name.BotName;

public class GetMyNameMethod implements Method<BotName> {

    private final GetMyName.GetMyNameBuilder method;

    public GetMyNameMethod() {
        this(GetMyName.builder());
    }

    public GetMyNameMethod(@NotNull GetMyName.GetMyNameBuilder method) {
        this.method = method;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public GetMyNameMethod setLanguageCode(@NotNull String languageCode) {
        method.languageCode(languageCode);
        return this;
    }

    @Override
    public BotName call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<BotName> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}