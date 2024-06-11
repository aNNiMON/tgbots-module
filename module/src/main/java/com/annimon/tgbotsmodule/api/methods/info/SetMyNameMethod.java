package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.name.SetMyName;

public class SetMyNameMethod implements Method<Boolean> {

    private final SetMyName.SetMyNameBuilder method;

    public SetMyNameMethod() {
        this(SetMyName.builder());
    }

    public SetMyNameMethod(@NotNull SetMyName.SetMyNameBuilder method) {
        this.method = method;
    }

    public String getName() {
        return method.build().getName();
    }

    public SetMyNameMethod setName(@NotNull String name) {
        method.name(name);
        return this;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public SetMyNameMethod setLanguageCode(@NotNull String languageCode) {
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