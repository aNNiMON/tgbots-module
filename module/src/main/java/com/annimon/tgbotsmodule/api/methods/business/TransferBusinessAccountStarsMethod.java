package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.TransferBusinessAccountStars;

public class TransferBusinessAccountStarsMethod implements BusinessConnectionMethod<TransferBusinessAccountStarsMethod, Boolean> {

    private final TransferBusinessAccountStars.TransferBusinessAccountStarsBuilder method;

    public TransferBusinessAccountStarsMethod() {
        this(TransferBusinessAccountStars.builder());
    }

    public TransferBusinessAccountStarsMethod(@NotNull TransferBusinessAccountStars.TransferBusinessAccountStarsBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public TransferBusinessAccountStarsMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Integer getStarCount() {
        return method.build().getStarCount();
    }

    public TransferBusinessAccountStarsMethod setStarCount(Integer starCount) {
        method.starCount(starCount);
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

