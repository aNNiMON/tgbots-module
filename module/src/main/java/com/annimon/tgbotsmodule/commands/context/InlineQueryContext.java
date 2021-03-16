package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.api.methods.answerqueries.AnswerInlineQueryMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;

public class InlineQueryContext extends Context {

    public InlineQueryContext(CommonAbsSender sender, Update update, String arguments) {
        super(sender, update, update.getInlineQuery().getFrom(), arguments);
    }

    public @NotNull InlineQuery inlineQuery() {
        return update.getInlineQuery();
    }

    public @NotNull String queryId() {
        return inlineQuery().getId();
    }

    public @NotNull String query() {
        return inlineQuery().getQuery();
    }

    public @NotNull String offset() {
        return inlineQuery().getOffset();
    }

    public @NotNull AnswerInlineQueryMethod answer() {
        return Methods.answerInlineQuery()
                .setInlineQueryId(queryId());
    }

    public @NotNull AnswerInlineQueryMethod answer(@NotNull InlineQueryResult... results) {
        return answer().setResults(results);
    }

    public @NotNull AnswerInlineQueryMethod answer(@NotNull List<InlineQueryResult> results) {
        return answer().setResults(results);
    }

    public @NotNull AnswerInlineQueryMethod answerArticle(
            @NotNull String id, @NotNull String title,
            @NotNull InputMessageContent content) {
        return answer(new InlineQueryResultArticle(id, title, content));
    }
}
