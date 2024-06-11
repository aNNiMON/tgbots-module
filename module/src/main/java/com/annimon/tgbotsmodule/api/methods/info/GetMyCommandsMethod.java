package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.commands.GetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;

public class GetMyCommandsMethod implements Method<ArrayList<BotCommand>> {

    private final GetMyCommands.GetMyCommandsBuilder method;

    public GetMyCommandsMethod() {
        this(GetMyCommands.builder());
    }

    public GetMyCommandsMethod(@NotNull GetMyCommands.GetMyCommandsBuilder method) {
        this.method = method;
    }

    public BotCommandScope getScope() {
        return method.build().getScope();
    }

    public GetMyCommandsMethod setScope(BotCommandScope scope){
        method.scope(scope);
        return this;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public GetMyCommandsMethod setLanguageCode(String languageCode){
        method.languageCode(languageCode);
        return this;
    }

    @Override
    public ArrayList<BotCommand> call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ArrayList<BotCommand>> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}