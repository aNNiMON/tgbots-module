package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.TextMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;

public class AnswerCallbackQueryMethod implements TextMethod<AnswerCallbackQueryMethod, Boolean> {

    private final AnswerCallbackQuery.AnswerCallbackQueryBuilder method;

    public AnswerCallbackQueryMethod() {
        this(AnswerCallbackQuery.builder());
    }

    public AnswerCallbackQueryMethod(@NotNull AnswerCallbackQuery.AnswerCallbackQueryBuilder method) {
        this.method = method;
    }

    public String getCallbackQueryId() {
        return method.build().getCallbackQueryId();
    }

    public AnswerCallbackQueryMethod setCallbackQueryId(@NotNull String callbackQueryId) {
        method.callbackQueryId(callbackQueryId);
        return this;
    }

    public Integer getCacheTime() {
        return method.build().getCacheTime();
    }

    public AnswerCallbackQueryMethod setCacheTime(Integer cacheTime) {
        method.cacheTime(cacheTime);
        return this;
    }

    @Override
    public String getText() {
        return method.build().getText();
    }

    @Override
    public AnswerCallbackQueryMethod setText(String text) {
        method.text(text);
        return this;
    }

    public Boolean getShowAlert() {
        return method.build().getShowAlert();
    }

    public AnswerCallbackQueryMethod setShowAlert(Boolean showAlert) {
        method.showAlert(showAlert);
        return this;
    }

    public String getUrl() {
        return method.build().getUrl();
    }

    public AnswerCallbackQueryMethod setUrl(String url) {
        method.url(url);
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