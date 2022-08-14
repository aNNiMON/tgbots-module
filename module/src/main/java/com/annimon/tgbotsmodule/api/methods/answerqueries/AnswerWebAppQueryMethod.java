package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.webapp.AnswerWebAppQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.webapp.SentWebAppMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AnswerWebAppQueryMethod implements Method<SentWebAppMessage> {

    private final AnswerWebAppQuery method;

    public AnswerWebAppQueryMethod() {
        this(new AnswerWebAppQuery());
    }

    public AnswerWebAppQueryMethod(@NotNull AnswerWebAppQuery method) {
        this.method = method;
    }

    public String getWebAppQueryId() {
        return method.getWebAppQueryId();
    }

    public AnswerWebAppQueryMethod setWebAppQueryId(@NotNull String webAppQueryId) {
        method.setWebAppQueryId(webAppQueryId);
        return this;
    }

    public InlineQueryResult getQueryResult() {
        return method.getQueryResult();
    }

    public AnswerWebAppQueryMethod setQueryResult(InlineQueryResult queryResult) {
        method.setQueryResult(queryResult);
        return this;
    }

    @Override
    public SentWebAppMessage call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super SentWebAppMessage> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}