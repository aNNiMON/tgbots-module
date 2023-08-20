package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.description.GetMyShortDescription;
import org.telegram.telegrambots.meta.api.objects.description.BotShortDescription;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetMyShortDescriptionMethod implements Method<BotShortDescription> {

    private final GetMyShortDescription method;

    public GetMyShortDescriptionMethod() {
        this(new GetMyShortDescription());
    }

    public GetMyShortDescriptionMethod(@NotNull GetMyShortDescription method) {
        this.method = method;
    }

    public String getLanguageCode() {
        return method.getLanguageCode();
    }

    public GetMyShortDescriptionMethod setLanguageCode(@NotNull String languageCode) {
        method.setLanguageCode(languageCode);
        return this;
    }

    @Override
    public BotShortDescription call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super BotShortDescription> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}