package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.description.GetMyDescription;
import org.telegram.telegrambots.meta.api.objects.description.BotDescription;

public class GetMyDescriptionMethod implements Method<BotDescription> {

    private final GetMyDescription.GetMyDescriptionBuilder method;

    public GetMyDescriptionMethod() {
        this(GetMyDescription.builder());
    }

    public GetMyDescriptionMethod(@NotNull GetMyDescription.GetMyDescriptionBuilder method) {
        this.method = method;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public GetMyDescriptionMethod setLanguageCode(@NotNull String languageCode) {
        method.languageCode(languageCode);
        return this;
    }

    @Override
    public BotDescription call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<BotDescription> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}