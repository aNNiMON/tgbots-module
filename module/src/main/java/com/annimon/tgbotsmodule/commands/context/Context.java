package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class Context {

    public final CommonAbsSender sender;
    protected final Update update;
    protected final User user;
    protected final String text;
    protected String[] arguments;
    protected int argumentsLimit;

    Context(CommonAbsSender sender, Update update, User user, String text) {
        this.sender = sender;
        this.update = update;
        this.user = user;
        this.text = text;
        this.argumentsLimit = 0;
    }

    public @NotNull Update update() {
        return update;
    }

    public @NotNull User user() {
        return user;
    }

    public String getText() {
        return text;
    }

    public @NotNull String argument(int index) {
        return argument(index, "");
    }

    public @NotNull String argument(int index, @NotNull String defaultValue) {
        if (index < 0 || index >= argumentsLength()) {
            return defaultValue;
        }
        return arguments[index];
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

    protected void createArguments() {
        arguments = text.isBlank() ? new String[]{} : text.split("\\s+", argumentsLimit);
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


}
