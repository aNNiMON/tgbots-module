package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class Context {

    public final CommonAbsSender sender;
    protected final Update update;
    protected final User user;
    protected final String argumentsAsString;
    protected String[] arguments;
    protected int argumentsLimit;

    public Context(CommonAbsSender sender, Update update, User user, String arguments) {
        this.sender = sender;
        this.update = update;
        this.user = user;
        this.argumentsAsString = arguments;
        this.argumentsLimit = 0;
    }

    public @NotNull Update update() {
        return update;
    }

    public @NotNull User user() {
        return user;
    }

    /**
     * Full arguments without the command.
     * If command has no arguments returns empty string.
     *
     * Examples:
     *  text: "/cmd arg1 arg2"
     *  args: "arg1 arg2"
     *  text: "/cmd"
     *  args: ""
     *
     * @return arguments string
     */
    public String argumentsAsString() {
        return argumentsAsString;
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

    public void setArgumentsLimit(int argumentsLimit) {
        if (argumentsLimit == this.argumentsLimit)
            return;

        this.argumentsLimit = argumentsLimit;
        createArguments();
    }

    protected void createArguments() {
        if (argumentsAsString.isBlank()) {
            arguments = new String[0];
        } else {
            arguments = argumentsAsString.split("\\s+", argumentsLimit);
        }
    }

    private void lazyCreateArguments() {
        if (arguments == null) {
            createArguments();
        }
    }
}
