package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class CallbackQueryContextBuilder {

    private CommonAbsSender sender;
    private Update update;
    private User user;
    private String argumentsAsString;

    public CallbackQueryContextBuilder setSender(CommonAbsSender sender) {
        this.sender = sender;
        return this;
    }

    public CallbackQueryContextBuilder setUpdate(Update update) {
        this.update = update;
        return this;
    }

    public CallbackQueryContextBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public CallbackQueryContextBuilder setArgumentsAsString(String text) {
        this.argumentsAsString = text;
        return this;
    }

    public CallbackQueryContext createContext() {
        return new CallbackQueryContext(sender, update, user, argumentsAsString);
    }
}
