package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.GetMyStarBalance;
import org.telegram.telegrambots.meta.api.objects.payments.star.StarAmount;

public class GetMyStarBalanceMethod implements Method<StarAmount> {

    private final GetMyStarBalance.GetMyStarBalanceBuilder<?, ?> method;

    public GetMyStarBalanceMethod() {
        this(GetMyStarBalance.builder());
    }

    public GetMyStarBalanceMethod(@NotNull GetMyStarBalance.GetMyStarBalanceBuilder<?, ?> method) {
        this.method = method;
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

