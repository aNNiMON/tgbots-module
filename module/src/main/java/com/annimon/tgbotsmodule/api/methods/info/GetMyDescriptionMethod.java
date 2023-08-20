package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.description.GetMyDescription;
import org.telegram.telegrambots.meta.api.objects.description.BotDescription;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetMyDescriptionMethod implements Method<BotDescription> {

    private final GetMyDescription method;

    public GetMyDescriptionMethod() {
        this(new GetMyDescription());
    }

    public GetMyDescriptionMethod(@NotNull GetMyDescription method) {
        this.method = method;
    }

    public String getLanguageCode() {
        return method.getLanguageCode();
    }

    public GetMyDescriptionMethod setLanguageCode(@NotNull String languageCode) {
        method.setLanguageCode(languageCode);
        return this;
    }

    @Override
    public BotDescription call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super BotDescription> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}