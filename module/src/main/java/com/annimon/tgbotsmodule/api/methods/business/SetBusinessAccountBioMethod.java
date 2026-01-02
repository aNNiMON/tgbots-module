package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.SetBusinessAccountBio;

public class SetBusinessAccountBioMethod implements BusinessConnectionMethod<SetBusinessAccountBioMethod, Boolean> {

    private final SetBusinessAccountBio.SetBusinessAccountBioBuilder method;

    public SetBusinessAccountBioMethod() {
        this(SetBusinessAccountBio.builder());
    }

    public SetBusinessAccountBioMethod(@NotNull SetBusinessAccountBio.SetBusinessAccountBioBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SetBusinessAccountBioMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public String getBio() {
        return method.build().getBio();
    }

    public SetBusinessAccountBioMethod setBio(String bio) {
        method.bio(bio);
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

