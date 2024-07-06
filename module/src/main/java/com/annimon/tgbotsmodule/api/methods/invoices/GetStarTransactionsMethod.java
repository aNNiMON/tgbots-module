package com.annimon.tgbotsmodule.api.methods.invoices;

import com.annimon.tgbotsmodule.api.methods.interfaces.PaginableMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.payments.star.GetStarTransactions;
import org.telegram.telegrambots.meta.api.objects.payments.star.StarTransactions;

public class GetStarTransactionsMethod implements PaginableMethod<GetStarTransactionsMethod, StarTransactions> {

    private final GetStarTransactions.GetStarTransactionsBuilder<?, ?> method;

    public GetStarTransactionsMethod() {
        this(GetStarTransactions.builder());
    }

    public GetStarTransactionsMethod(GetStarTransactions.GetStarTransactionsBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public Integer getOffset() {
        return method.build().getOffset();
    }

    @Override
    public GetStarTransactionsMethod setOffset(Integer offset) {
        method.offset(offset);
        return this;
    }

    @Override
    public Integer getLimit() {
        return method.build().getLimit();
    }

    @Override
    public GetStarTransactionsMethod setLimit(Integer limit) {
        method.limit(limit);
        return this;
    }

    @Override
    public StarTransactions call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<StarTransactions> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
