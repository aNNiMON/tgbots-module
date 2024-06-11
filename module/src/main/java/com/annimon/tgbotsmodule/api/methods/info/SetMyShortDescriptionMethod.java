package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.description.SetMyShortDescription;

public class SetMyShortDescriptionMethod implements Method<Boolean> {

    private final SetMyShortDescription.SetMyShortDescriptionBuilder method;

    public SetMyShortDescriptionMethod() {
        this(SetMyShortDescription.builder());
    }

    public SetMyShortDescriptionMethod(@NotNull SetMyShortDescription.SetMyShortDescriptionBuilder method) {
        this.method = method;
    }

    public String getShortDescription() {
        return method.build().getShortDescription();
    }

    public SetMyShortDescriptionMethod setShortDescription(@NotNull String shortDescription) {
        method.shortDescription(shortDescription);
        return this;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public SetMyShortDescriptionMethod setLanguageCode(@NotNull String languageCode) {
        method.languageCode(languageCode);
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