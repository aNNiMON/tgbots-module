package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultsButton;

public class AnswerInlineQueryMethod implements Method<Boolean> {

    private final AnswerInlineQuery.AnswerInlineQueryBuilder method;

    public AnswerInlineQueryMethod() {
        this(AnswerInlineQuery.builder());
    }

    public AnswerInlineQueryMethod(@NotNull AnswerInlineQuery.AnswerInlineQueryBuilder method) {
        this.method = method;
    }

    public String getInlineQueryId() {
        return method.build().getInlineQueryId();
    }

    public AnswerInlineQueryMethod setInlineQueryId(@NotNull String inlineQueryId) {
        method.inlineQueryId(inlineQueryId);
        return this;
    }

    public Integer getCacheTime() {
        return method.build().getCacheTime();
    }

    public AnswerInlineQueryMethod setCacheTime(Integer cacheTime) {
        method.cacheTime(cacheTime);
        return this;
    }

    public String getNextOffset() {
        return method.build().getNextOffset();
    }

    public AnswerInlineQueryMethod setNextOffset(String nextOffset) {
        method.nextOffset(nextOffset);
        return this;
    }

    public Boolean isPersonal() {
        return method.build().getIsPersonal();
    }

    public AnswerInlineQueryMethod setPersonal(Boolean isPersonal) {
        method.isPersonal(isPersonal);
        return this;
    }

    public InlineQueryResultsButton getButton() {
        return method.build().getButton();
    }

    public AnswerInlineQueryMethod setButton(@Nullable InlineQueryResultsButton button) {
        method.button(button);
        return this;
    }

    public List<InlineQueryResult> getResults() {
        return method.build().getResults();
    }

    public AnswerInlineQueryMethod setResults(@NotNull List<InlineQueryResult> results) {
        method.results(results);
        return this;
    }

    public AnswerInlineQueryMethod setResults(@NotNull InlineQueryResult... results) {
        method.results(List.of(results));
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