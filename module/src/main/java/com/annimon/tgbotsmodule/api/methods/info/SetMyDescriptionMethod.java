package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.description.SetMyDescription;

public class SetMyDescriptionMethod implements Method<Boolean> {

    private final SetMyDescription.SetMyDescriptionBuilder method;

    public SetMyDescriptionMethod() {
        this(SetMyDescription.builder());
    }

    public SetMyDescriptionMethod(@NotNull SetMyDescription.SetMyDescriptionBuilder method) {
        this.method = method;
    }

    public String getDescription() {
        return method.build().getDescription();
    }

    public SetMyDescriptionMethod setDescription(@NotNull String description) {
        method.description(description);
        return this;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public SetMyDescriptionMethod setLanguageCode(@NotNull String languageCode) {
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