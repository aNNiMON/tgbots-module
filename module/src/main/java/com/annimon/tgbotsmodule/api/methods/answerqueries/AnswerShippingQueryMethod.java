package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.AnswerShippingQuery;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingOption;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AnswerShippingQueryMethod implements Method<Boolean> {

    private final AnswerShippingQuery method;

    public AnswerShippingQueryMethod() {
        this(new AnswerShippingQuery());
    }

    public AnswerShippingQueryMethod(@NotNull AnswerShippingQuery method) {
        this.method = method;
    }

    public String getShippingQueryId() {
        return method.getShippingQueryId();
    }

    public AnswerShippingQueryMethod setShippingQueryId(@NotNull String shippingQueryId) {
        method.setShippingQueryId(shippingQueryId);
        return this;
    }

    public List<ShippingOption> getShippingOptions() {
        return method.getShippingOptions();
    }

    public AnswerShippingQueryMethod setShippingOptions(List<ShippingOption> shippingOptions) {
        method.setShippingOptions(shippingOptions);
        return this;
    }

    public Boolean getOk() {
        return method.getOk();
    }

    public AnswerShippingQueryMethod setOk(Boolean isPersonal) {
        method.setOk(isPersonal);
        return this;
    }

    public String getErrorMessage() {
        return method.getErrorMessage();
    }

    public AnswerShippingQueryMethod setErrorMessage(String errorMessage) {
        method.setErrorMessage(errorMessage);
        return this;
    }

    @Override
    public Boolean execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Boolean> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}