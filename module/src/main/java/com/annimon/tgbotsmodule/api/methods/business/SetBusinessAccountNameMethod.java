package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.SetBusinessAccountName;

public class SetBusinessAccountNameMethod implements BusinessConnectionMethod<SetBusinessAccountNameMethod, Boolean> {

    private final SetBusinessAccountName.SetBusinessAccountNameBuilder method;

    public SetBusinessAccountNameMethod() {
        this(SetBusinessAccountName.builder());
    }

    public SetBusinessAccountNameMethod(@NotNull SetBusinessAccountName.SetBusinessAccountNameBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SetBusinessAccountNameMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public String getFirstName() {
        return method.build().getFirstName();
    }

    public SetBusinessAccountNameMethod setFirstName(String firstName) {
        method.firstName(firstName);
        return this;
    }

    public String getLastName() {
        return method.build().getLastName();
    }

    public SetBusinessAccountNameMethod setLastName(String lastName) {
        method.lastName(lastName);
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

