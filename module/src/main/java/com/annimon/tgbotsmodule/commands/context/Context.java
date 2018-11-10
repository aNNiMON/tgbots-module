package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class Context {

    public final CommonAbsSender sender;
    protected final Update update;
    protected final User user;

    Context(CommonAbsSender sender, Update update, User user) {
        this.sender = sender;
        this.update = update;
        this.user = user;
    }

    public Update update() {
        return update;
    }

    public User user() {
        return user;
    }
}
