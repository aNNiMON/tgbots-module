package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultsButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AnswerInlineQueryMethod implements Method<Boolean> {

    private final AnswerInlineQuery method;

    public AnswerInlineQueryMethod() {
        this(new AnswerInlineQuery());
    }

    public AnswerInlineQueryMethod(@NotNull AnswerInlineQuery method) {
        this.method = method;
    }

    public String getInlineQueryId() {
        return method.getInlineQueryId();
    }

    public AnswerInlineQueryMethod setInlineQueryId(@NotNull String inlineQueryId) {
        method.setInlineQueryId(inlineQueryId);
        return this;
    }

    public Integer getCacheTime() {
        return method.getCacheTime();
    }

    public AnswerInlineQueryMethod setCacheTime(Integer cacheTime) {
        method.setCacheTime(cacheTime);
        return this;
    }

    public String getNextOffset() {
        return method.getNextOffset();
    }

    public AnswerInlineQueryMethod setNextOffset(String nextOffset) {
        method.setNextOffset(nextOffset);
        return this;
    }

    public Boolean isPersonal() {
        return method.getIsPersonal();
    }

    public AnswerInlineQueryMethod setPersonal(Boolean isPersonal) {
        method.setIsPersonal(isPersonal);
        return this;
    }

    /**
     * @deprecated Use {@link #getButton()}
     */
    @Deprecated
    public String getSwitchPmText() {
        return method.getSwitchPmText();
    }

    /**
     * @deprecated Use {@link #setButton(InlineQueryResultsButton)}
     */
    @Deprecated
    public AnswerInlineQueryMethod setSwitchPmText(String switchPmText) {
        method.setSwitchPmText(switchPmText);
        return this;
    }

    /**
     * @deprecated Use {@link #getButton()}
     */
    @Deprecated
    public String getSwitchPmParameter() {
        return method.getSwitchPmParameter();
    }

    /**
     * @deprecated Use {@link #setButton(InlineQueryResultsButton)}
     */
    @Deprecated
    public AnswerInlineQueryMethod setSwitchPmParameter(String switchPmParameter) {
        method.setSwitchPmParameter(switchPmParameter);
        return this;
    }

    public InlineQueryResultsButton getButton() {
        return method.getButton();
    }

    public AnswerInlineQueryMethod setButton(@Nullable InlineQueryResultsButton button) {
        method.setButton(button);
        return this;
    }

    public List<InlineQueryResult> getResults() {
        return method.getResults();
    }

    public AnswerInlineQueryMethod setResults(@NotNull List<InlineQueryResult> results) {
        method.setResults(results);
        return this;
    }

    public AnswerInlineQueryMethod setResults(@NotNull InlineQueryResult... results) {
        method.setResults(List.of(results));
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Boolean> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}