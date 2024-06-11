package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;

public class SetMyCommandsMethod implements Method<Boolean> {

    private final SetMyCommands.SetMyCommandsBuilder method;

    public SetMyCommandsMethod() {
        this(SetMyCommands.builder());
    }

    public SetMyCommandsMethod(@NotNull SetMyCommands.SetMyCommandsBuilder method) {
        this.method = method;
    }

    public List<BotCommand> getCommands() {
        return method.build().getCommands();
    }

    public SetMyCommandsMethod setCommands(List<BotCommand> commands) {
        method.commands(commands);
        return this;
    }

    public BotCommandScope getScope() {
        return method.build().getScope();
    }

    public SetMyCommandsMethod setScope(BotCommandScope scope){
        method.scope(scope);
        return this;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public SetMyCommandsMethod setLanguageCode(String languageCode){
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