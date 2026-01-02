package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.SetBusinessAccountUsername;

public class SetBusinessAccountUsernameMethod implements BusinessConnectionMethod<SetBusinessAccountUsernameMethod, Boolean> {

    private final SetBusinessAccountUsername.SetBusinessAccountUsernameBuilder method;

    public SetBusinessAccountUsernameMethod() {
        this(SetBusinessAccountUsername.builder());
    }

    public SetBusinessAccountUsernameMethod(@NotNull SetBusinessAccountUsername.SetBusinessAccountUsernameBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SetBusinessAccountUsernameMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public String getUsername() {
        return method.build().getUsername();
    }

    public SetBusinessAccountUsernameMethod setUsername(String username) {
        method.username(username);
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
