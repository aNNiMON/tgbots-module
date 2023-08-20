package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.name.SetMyName;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetMyNameMethod implements Method<Boolean> {

    private final SetMyName method;

    public SetMyNameMethod() {
        this(new SetMyName());
    }

    public SetMyNameMethod(@NotNull SetMyName method) {
        this.method = method;
    }

    public String getName() {
        return method.getName();
    }

    public SetMyNameMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    public String getLanguageCode() {
        return method.getLanguageCode();
    }

    public SetMyNameMethod setLanguageCode(@NotNull String languageCode) {
        method.setLanguageCode(languageCode);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Boolean> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}