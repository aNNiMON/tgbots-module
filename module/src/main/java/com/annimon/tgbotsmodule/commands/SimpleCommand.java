package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.context.MessageContext;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Consumer;

public class SimpleCommand implements TextCommand<For> {

    private final String command;
    private final Set<String> aliases;
    private final Consumer<MessageContext> contextConsumer;
    private final EnumSet<For> authority;

    public SimpleCommand(@NotNull String command,
                         @NotNull Consumer<MessageContext> contextConsumer) {
        this(command, EnumSet.of(For.ALL), contextConsumer);
    }

    public SimpleCommand(@NotNull String command,
                         @NotNull EnumSet<For> authority,
                         @NotNull Consumer<MessageContext> contextConsumer) {
        this(command, Set.of(), authority, contextConsumer);
    }

    public SimpleCommand(@NotNull String command,
                         @NotNull Set<String> aliases,
                         @NotNull EnumSet<For> authority,
                         @NotNull Consumer<MessageContext> contextConsumer) {
        this.command = command;
        this.aliases = aliases;
        this.contextConsumer = contextConsumer;
        this.authority = authority;
    }

    @Override
    public String command() {
        return command;
    }

    @Override
    public Set<String> aliases() {
        return aliases;
    }

    @Override
    public EnumSet<For> authority() {
        return authority;
    }

    @Override
    public void accept(@NotNull MessageContext context) {
        contextConsumer.accept(context);
    }
}
