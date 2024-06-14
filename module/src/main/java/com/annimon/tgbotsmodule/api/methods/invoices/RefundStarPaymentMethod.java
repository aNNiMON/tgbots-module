package com.annimon.tgbotsmodule.api.methods.invoices;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.payments.RefundStarPayment;

public class RefundStarPaymentMethod implements UserMethod<RefundStarPaymentMethod, Boolean> {

    private final RefundStarPayment.RefundStarPaymentBuilder<?, ?> method;

    public RefundStarPaymentMethod() {
        this(RefundStarPayment.builder());
    }

    public RefundStarPaymentMethod(RefundStarPayment.RefundStarPaymentBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return /* TODO fix */Long.valueOf(method.build().getUserId());
    }

    @Override
    public RefundStarPaymentMethod setUserId(Long userId) {
        method.userId(userId.intValue() /* FIX */);
        return this;
    }

    public String getTelegramPaymentChargeId() {
        return method.build().getTelegramPaymentChargeId();
    }

    public RefundStarPaymentMethod setTelegramPaymentChargeId(String id) {
        method.telegramPaymentChargeId(id);
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
