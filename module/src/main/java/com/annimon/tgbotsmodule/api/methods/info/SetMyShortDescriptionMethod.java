package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.description.SetMyShortDescription;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetMyShortDescriptionMethod implements Method<Boolean> {

    private final SetMyShortDescription method;

    public SetMyShortDescriptionMethod() {
        this(new SetMyShortDescription());
    }

    public SetMyShortDescriptionMethod(@NotNull SetMyShortDescription method) {
        this.method = method;
    }

    public String getShortDescription() {
        return method.getShortDescription();
    }

    public SetMyShortDescriptionMethod setShortDescription(@NotNull String shortDescription) {
        method.setShortDescription(shortDescription);
        return this;
    }

    public String getLanguageCode() {
        return method.getLanguageCode();
    }

    public SetMyShortDescriptionMethod setLanguageCode(@NotNull String languageCode) {
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