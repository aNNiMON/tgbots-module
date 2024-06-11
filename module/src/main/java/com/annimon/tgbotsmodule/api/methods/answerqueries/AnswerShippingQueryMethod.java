package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.AnswerShippingQuery;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingOption;

public class AnswerShippingQueryMethod implements Method<Boolean> {

    private final AnswerShippingQuery.AnswerShippingQueryBuilder method;

    public AnswerShippingQueryMethod() {
        this(AnswerShippingQuery.builder());
    }

    public AnswerShippingQueryMethod(@NotNull AnswerShippingQuery.AnswerShippingQueryBuilder method) {
        this.method = method;
    }

    public String getShippingQueryId() {
        return method.build().getShippingQueryId();
    }

    public AnswerShippingQueryMethod setShippingQueryId(@NotNull String shippingQueryId) {
        method.shippingQueryId(shippingQueryId);
        return this;
    }

    public List<ShippingOption> getShippingOptions() {
        return method.build().getShippingOptions();
    }

    public AnswerShippingQueryMethod setShippingOptions(List<ShippingOption> shippingOptions) {
        method.shippingOptions(shippingOptions);
        return this;
    }

    public boolean getOk() {
        return Boolean.TRUE.equals(method.build().getOk());
    }

    public AnswerShippingQueryMethod setOk(boolean isPersonal) {
        method.ok(isPersonal);
        return this;
    }

    public String getErrorMessage() {
        return method.build().getErrorMessage();
    }

    public AnswerShippingQueryMethod setErrorMessage(String errorMessage) {
        method.errorMessage(errorMessage);
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