package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.api.methods.answerqueries.AnswerCallbackQueryMethod;
import com.annimon.tgbotsmodule.api.methods.updatingmessages.EditMessageTextMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class CallbackQueryContext extends Context {

    private String[] arguments;
    private int argumentsLimit;

    CallbackQueryContext(CommonAbsSender sender, Update update, User user) {
        super(sender, update, user);
    }

    public @NotNull String queryId() {
        return update.getCallbackQuery().getId();
    }

    public @NotNull CallbackQuery callbackQuery() {
        return update.getCallbackQuery();
    }

    public @NotNull Message message() {
        return update.getCallbackQuery().getMessage();
    }

    public String data() {
        return update.getCallbackQuery().getData();
    }

    public String gameShortName() {
        return update.getCallbackQuery().getGameShortName();
    }

    public @NotNull String argument(int index) {
        return argument(index, "");
    }

    public @NotNull String argument(int index, @NotNull String defaultValue) {
        lazyCreateArguments();
        if (index >= 0 && index < arguments.length) {
            return arguments[index];
        }
        return defaultValue;
    }

    public @NotNull String[] arguments() {
        lazyCreateArguments();
        return arguments;
    }

    public int argumentsLength() {
        return arguments().length;
    }

    public int argumentsLimit() {
        return argumentsLimit;
    }

    private void createArguments() {
        arguments = update.getCallbackQuery().getData().split("\\s+", argumentsLimit);
    }

    private void lazyCreateArguments() {
        if (arguments == null) {
            createArguments();
        }
    }

    public void setArgumentsLimit(int argumentsLimit) {
        if (argumentsLimit == this.argumentsLimit)
            return;

        this.argumentsLimit = argumentsLimit;
        createArguments();
    }

    public @NotNull AnswerCallbackQueryMethod answer(String text) {
        return Methods.answerCallbackQuery(queryId())
                .setText(text);
    }

    public @NotNull AnswerCallbackQueryMethod answer(String text, boolean showAsAlert) {
        return answer(text).setShowAlert(showAsAlert);
    }

    public @NotNull AnswerCallbackQueryMethod answerAsAlert(String text) {
        return answer(text, true);
    }

    public @NotNull AnswerCallbackQueryMethod answerWithUrl(String url) {
        return Methods.answerCallbackQuery(queryId())
                .setUrl(url);
    }

    public @NotNull EditMessageTextMethod editMessage(String text) {
        return Methods.editMessageText()
                .setChatId(message().getChatId())
                .setMessageId(message().getMessageId())
                .setText(text);
    }

    public @NotNull EditMessageTextMethod editMessage(String text, InlineKeyboardMarkup markup) {
        return editMessage(text).setReplyMarkup(markup);
    }

    public @NotNull EditMessageTextMethod removeMarkup() {
        return editMessage(message().getText())
                .setEntities(message().getEntities())
                .setReplyMarkup(null);
    }
}
