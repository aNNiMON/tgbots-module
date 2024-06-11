package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.description.GetMyShortDescription;
import org.telegram.telegrambots.meta.api.objects.description.BotShortDescription;

public class GetMyShortDescriptionMethod implements Method<BotShortDescription> {

    private final GetMyShortDescription.GetMyShortDescriptionBuilder method;

    public GetMyShortDescriptionMethod() {
        this(GetMyShortDescription.builder());
    }

    public GetMyShortDescriptionMethod(@NotNull GetMyShortDescription.GetMyShortDescriptionBuilder method) {
        this.method = method;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public GetMyShortDescriptionMethod setLanguageCode(@NotNull String languageCode) {
        method.languageCode(languageCode);
        return this;
    }

    @Override
    public BotShortDescription call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<BotShortDescription> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}