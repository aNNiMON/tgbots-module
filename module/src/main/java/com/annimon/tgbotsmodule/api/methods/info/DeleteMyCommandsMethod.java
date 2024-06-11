package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.commands.DeleteMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScope;

public class DeleteMyCommandsMethod implements Method<Boolean> {

    private final DeleteMyCommands.DeleteMyCommandsBuilder method;

    public DeleteMyCommandsMethod() {
        this(DeleteMyCommands.builder());
    }

    public DeleteMyCommandsMethod(@NotNull DeleteMyCommands.DeleteMyCommandsBuilder method) {
        this.method = method;
    }

    public BotCommandScope getScope() {
        return method.build().getScope();
    }

    public DeleteMyCommandsMethod setScope(BotCommandScope scope) {
        method.scope(scope);
        return this;
    }

    public String getLanguageCode() {
        return method.build().getLanguageCode();
    }

    public DeleteMyCommandsMethod setLanguageCode(String languageCode) {
        method.languageCode(languageCode);
        return this;
    }

    @Override
    public Boolean call(CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
