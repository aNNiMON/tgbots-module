package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.AnswerPreCheckoutQuery;

public class AnswerPreCheckoutQueryMethod implements Method<Boolean> {

    private final AnswerPreCheckoutQuery.AnswerPreCheckoutQueryBuilder method;

    public AnswerPreCheckoutQueryMethod() {
        this(AnswerPreCheckoutQuery.builder());
    }

    public AnswerPreCheckoutQueryMethod(@NotNull AnswerPreCheckoutQuery.AnswerPreCheckoutQueryBuilder method) {
        this.method = method;
    }

    public String getPreCheckoutQueryId() {
        return method.build().getPreCheckoutQueryId();
    }

    public AnswerPreCheckoutQueryMethod setPreCheckoutQueryId(@NotNull String preCheckoutQueryId) {
        method.preCheckoutQueryId(preCheckoutQueryId);
        return this;
    }

    public boolean getOk() {
        return method.build().getOk();
    }

    public AnswerPreCheckoutQueryMethod setOk(boolean isPersonal) {
        method.ok(isPersonal);
        return this;
    }

    public String getErrorMessage() {
        return method.build().getErrorMessage();
    }

    public AnswerPreCheckoutQueryMethod setErrorMessage(String errorMessage) {
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