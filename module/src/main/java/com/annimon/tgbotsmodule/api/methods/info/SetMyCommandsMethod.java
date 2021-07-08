package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetMyCommandsMethod implements Method<Boolean> {

    private final SetMyCommands method;

    public SetMyCommandsMethod() {
        this(new SetMyCommands());
    }

    public SetMyCommandsMethod(@NotNull SetMyCommands method) {
        this.method = method;
    }

    public List<BotCommand> getCommands() {
        return method.getCommands();
    }

    public SetMyCommandsMethod setCommands(List<BotCommand> commands) {
        method.setCommands(commands);
        return this;
    }

    public SetMyCommandsMethod setScope(BotCommandScope scope){
        method.setScope(scope);
        return this;
    }

    public SetMyCommandsMethod setLanguageCode(String languageCode){
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