package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.analytics.UpdateHandler;
import com.annimon.tgbotsmodule.commands.authority.Authority;
import com.annimon.tgbotsmodule.commands.context.MessageContext;
import com.annimon.tgbotsmodule.commands.context.MessageContextBuilder;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CommandRegistry implements UpdateHandler {

    private final BotHandler handler;
    private final String botUsername;
    private final ListMultimap<String, TextCommand> textCommands;
    private final Authority authority;

    public CommandRegistry(@NotNull BotHandler handler, @NotNull Authority authority) {
        this.handler = handler;
        this.authority = authority;
        this.botUsername = "@" + handler.getBotUsername().toLowerCase(Locale.ENGLISH);
        textCommands = ArrayListMultimap.create();
    }

    public CommandRegistry register(@NotNull TextCommand command) {
        Objects.requireNonNull(command);
        textCommands.put(stringToCommand(command.command()), command);
        return this;
    }

    @Override
    public boolean handleUpdate(@NotNull Update update) {
        final var message = update.getMessage();
        // Texr commands
        if (update.hasMessage() && message.hasText()) {
            final var args = message.getText().split("\\s+", 2);
            final var command = stringToCommand(args[0]);
            final var commands = Stream.ofNullable(textCommands.get(command))
                    .flatMap(Collection::stream)
                    .filter(cmd -> authority.hasRights(message.getFrom(), cmd.authority()))
                    .collect(Collectors.toList());
            if (!commands.isEmpty()) {
                final MessageContext context = new MessageContextBuilder()
                        .setSender(handler)
                        .setUpdate(update)
                        .setUser(message.getFrom())
                        .setChatId(message.getChatId())
                        .setText(args.length >= 2 ? args[1] : "")
                        .createContext();
                for (TextCommand cmd : commands) {
                    cmd.accept(context);
                }
                return true;
            }
        }
        return false;
    }

    private String stringToCommand(String str) {
        return str.toLowerCase(Locale.ENGLISH).replace(botUsername, "");
    }
}
