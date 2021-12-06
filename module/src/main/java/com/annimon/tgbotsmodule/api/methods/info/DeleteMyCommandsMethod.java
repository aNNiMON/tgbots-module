package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.commands.DeleteMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeleteMyCommandsMethod implements Method<Boolean> {

    private final DeleteMyCommands method;

    public DeleteMyCommandsMethod() {
        this(new DeleteMyCommands());
    }

    public DeleteMyCommandsMethod(@NotNull DeleteMyCommands method) {
        this.method = method;
    }

    public DeleteMyCommandsMethod setScope(BotCommandScope scope) {
        method.setScope(scope);
        return this;
    }

    public DeleteMyCommandsMethod setLanguageCode(String languageCode) {
        method.setLanguageCode(languageCode);
        return this;
    }

    @Override
    public Boolean call(CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @NotNull Consumer<? super Boolean> responseConsumer,
                          @NotNull Consumer<TelegramApiException> apiExceptionConsumer,
                          @NotNull Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, exceptionConsumer);
    }
}
