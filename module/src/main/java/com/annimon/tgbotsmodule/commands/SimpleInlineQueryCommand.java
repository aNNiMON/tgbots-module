package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.context.InlineQueryContext;
import java.util.EnumSet;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class SimpleInlineQueryCommand implements InlineQueryCommand {

    private final String command;
    private final Consumer<InlineQueryContext> contextConsumer;
    private final EnumSet<For> authority;

    public SimpleInlineQueryCommand(@NotNull String command,
                                    @NotNull Consumer<InlineQueryContext> contextConsumer) {
        this(command, For.all(), contextConsumer);
    }

    public SimpleInlineQueryCommand(@NotNull String command,
                                    @NotNull For role,
                                    @NotNull Consumer<InlineQueryContext> contextConsumer) {
        this(command, EnumSet.of(role), contextConsumer);
    }

    public SimpleInlineQueryCommand(@NotNull String command,
                                    @NotNull EnumSet<For> authority,
                                    @NotNull Consumer<InlineQueryContext> contextConsumer) {
        this.command = command;
        this.contextConsumer = contextConsumer;
        this.authority = authority;
    }

    @Override
    public String command() {
        return command;
    }

    @SuppressWarnings("unchecked")
    @Override
    public EnumSet<For> authority() {
        return authority;
    }

    @Override
    public void accept(@NotNull InlineQueryContext context) {
        contextConsumer.accept(context);
    }
}
