package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.TextMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AnswerCallbackQueryMethod implements TextMethod<AnswerCallbackQueryMethod, Boolean> {

    private final AnswerCallbackQuery method;

    public AnswerCallbackQueryMethod() {
        this(new AnswerCallbackQuery());
    }

    public AnswerCallbackQueryMethod(@NotNull AnswerCallbackQuery method) {
        this.method = method;
    }

    public String getCallbackQueryId() {
        return method.getCallbackQueryId();
    }

    public AnswerCallbackQueryMethod setCallbackQueryId(@NotNull String callbackQueryId) {
        method.setCallbackQueryId(callbackQueryId);
        return this;
    }

    public Integer getCacheTime() {
        return method.getCacheTime();
    }

    public AnswerCallbackQueryMethod setCacheTime(Integer cacheTime) {
        method.setCacheTime(cacheTime);
        return this;
    }

    @Override
    public String getText() {
        return method.getText();
    }

    @Override
    public AnswerCallbackQueryMethod setText(String text) {
        method.setText(text);
        return this;
    }

    public Boolean getShowAlert() {
        return method.getShowAlert();
    }

    public AnswerCallbackQueryMethod setShowAlert(Boolean showAlert) {
        method.setShowAlert(showAlert);
        return this;
    }

    public String getUrl() {
        return method.getUrl();
    }

    public AnswerCallbackQueryMethod setUrl(String url) {
        method.setUrl(url);
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