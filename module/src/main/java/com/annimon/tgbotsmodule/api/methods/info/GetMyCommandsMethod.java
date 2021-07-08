package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.GetMe;
import org.telegram.telegrambots.meta.api.methods.commands.GetMyCommands;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetMyCommandsMethod implements Method<ArrayList<BotCommand>> {

    private final GetMyCommands method;

    public GetMyCommandsMethod() {
        this(new GetMyCommands());
    }

    public GetMyCommandsMethod(@NotNull GetMyCommands method) {
        this.method = method;
    }

    public GetMyCommandsMethod setScope(BotCommandScope scope){
        method.setScope(scope);
        return this;
    }

    public GetMyCommandsMethod setLanguageCode(String languageCode){
        method.setLanguageCode(languageCode);
        return this;
    }

    @Override
    public ArrayList<BotCommand> call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super ArrayList<BotCommand>> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}