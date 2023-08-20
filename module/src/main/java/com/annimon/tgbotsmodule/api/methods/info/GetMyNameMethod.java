package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.name.GetMyName;
import org.telegram.telegrambots.meta.api.objects.name.BotName;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetMyNameMethod implements Method<BotName> {

    private final GetMyName method;

    public GetMyNameMethod() {
        this(new GetMyName() {
            @Override
            public String getMethod() {
                return "getMyName"; // TODO: remove when will be fixed in telegrambots
            }
        });
    }

    public GetMyNameMethod(@NotNull GetMyName method) {
        this.method = method;
    }

    public String getLanguageCode() {
        return method.getLanguageCode();
    }

    public GetMyNameMethod setLanguageCode(@NotNull String languageCode) {
        method.setLanguageCode(languageCode);
        return this;
    }

    @Override
    public BotName call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super BotName> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}