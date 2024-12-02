package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.webapp.AnswerWebAppQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.webapp.SentWebAppMessage;

public class AnswerWebAppQueryMethod implements Method<SentWebAppMessage> {

    private final AnswerWebAppQuery.AnswerWebAppQueryBuilder<?, ?> method;

    public AnswerWebAppQueryMethod() {
        this(AnswerWebAppQuery.builder());
    }

    public AnswerWebAppQueryMethod(@NotNull AnswerWebAppQuery.AnswerWebAppQueryBuilder method) {
        this.method = method;
    }

    public String getWebAppQueryId() {
        return method.build().getWebAppQueryId();
    }

    public AnswerWebAppQueryMethod setWebAppQueryId(@NotNull String webAppQueryId) {
        method.webAppQueryId(webAppQueryId);
        return this;
    }

    public InlineQueryResult getQueryResult() {
        return method.build().getQueryResult();
    }

    public AnswerWebAppQueryMethod setQueryResult(InlineQueryResult queryResult) {
        method.queryResult(queryResult);
        return this;
    }

    @Override
    public SentWebAppMessage call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<SentWebAppMessage> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}