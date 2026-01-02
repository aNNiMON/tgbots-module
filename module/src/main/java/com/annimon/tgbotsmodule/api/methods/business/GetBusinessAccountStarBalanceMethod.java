package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.GetBusinessAccountStarBalance;
import org.telegram.telegrambots.meta.api.objects.payments.star.StarAmount;

public class GetBusinessAccountStarBalanceMethod implements BusinessConnectionMethod<GetBusinessAccountStarBalanceMethod, StarAmount> {

    private final GetBusinessAccountStarBalance.GetBusinessAccountStarBalanceBuilder method;

    public GetBusinessAccountStarBalanceMethod() {
        this(GetBusinessAccountStarBalance.builder());
    }

    public GetBusinessAccountStarBalanceMethod(@NotNull GetBusinessAccountStarBalance.GetBusinessAccountStarBalanceBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public GetBusinessAccountStarBalanceMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public StarAmount call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<StarAmount> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}

