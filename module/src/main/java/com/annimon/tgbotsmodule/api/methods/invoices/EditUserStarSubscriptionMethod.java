package com.annimon.tgbotsmodule.api.methods.invoices;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.payments.star.EditUserStarSubscription;

public class EditUserStarSubscriptionMethod implements UserMethod<EditUserStarSubscriptionMethod, Boolean> {

    private final EditUserStarSubscription.EditUserStarSubscriptionBuilder<?, ?> method;

    public EditUserStarSubscriptionMethod() {
        this(EditUserStarSubscription.builder());
    }

    public EditUserStarSubscriptionMethod(EditUserStarSubscription.EditUserStarSubscriptionBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public EditUserStarSubscriptionMethod setUserId(Long userId) {
        method.userId(userId);
        return this;
    }

    public String getTelegramPaymentChargeId() {
        return method.build().getTelegramPaymentChargeId();
    }

    public EditUserStarSubscriptionMethod setTelegramPaymentChargeId(String id) {
        method.telegramPaymentChargeId(id);
        return this;
    }

    public Boolean getIsCanceled() {
        return method.build().getIsCanceled();
    }

    public EditUserStarSubscriptionMethod setIsCanceled(Boolean canceled) {
        method.isCanceled(canceled);
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
