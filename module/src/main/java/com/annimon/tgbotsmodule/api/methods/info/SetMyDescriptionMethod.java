package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.description.SetMyDescription;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetMyDescriptionMethod implements Method<Boolean> {

    private final SetMyDescription method;

    public SetMyDescriptionMethod() {
        this(new SetMyDescription());
    }

    public SetMyDescriptionMethod(@NotNull SetMyDescription method) {
        this.method = method;
    }

    public String getDescription() {
        return method.getDescription();
    }

    public SetMyDescriptionMethod setDescription(@NotNull String description) {
        method.setDescription(description);
        return this;
    }

    public String getLanguageCode() {
        return method.getLanguageCode();
    }

    public SetMyDescriptionMethod setLanguageCode(@NotNull String languageCode) {
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