package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.analytics.UpdateHandler;
import com.annimon.tgbotsmodule.commands.authority.Authority;
import com.annimon.tgbotsmodule.commands.context.MessageContext;
import com.annimon.tgbotsmodule.commands.context.MessageContextBuilder;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CommandRegistry implements UpdateHandler {

    private final BotHandler handler;
    private final String botUsername;
    private final ListMultimap<String, TextCommand> textCommands;
    private final List<RegexCommand> regexCommands;
    private final Authority authority;

    public CommandRegistry(@NotNull BotHandler handler, @NotNull Authority authority) {
        this.handler = handler;
        this.authority = authority;
        this.botUsername = "@" + handler.getBotUsername().toLowerCase(Locale.ENGLISH);
        textCommands = ArrayListMultimap.create();
        regexCommands = new ArrayList<>();
    }

    public CommandRegistry register(@NotNull TextCommand command) {
        Objects.requireNonNull(command);
        Stream.concat(Stream.of(command.command()), command.aliases().stream())
                .map(this::stringToCommand)
                .forEach(key -> textCommands.put(key, command));
        return this;
    }

    public CommandRegistry register(@NotNull RegexCommand command) {
        Objects.requireNonNull(command);
        regexCommands.add(command);
        return this;
    }

    public CommandRegistry registerBundle(@NotNull CommandBundle bundle) {
        Objects.requireNonNull(bundle);
        bundle.register(this);
        return this;
    }

    @Override
    public boolean handleUpdate(@NotNull Update update) {
        if (update.hasMessage()) {
            // Text commands
            if (update.getMessage().hasText()) {
                if ((!textCommands.isEmpty()) && handleTextCommands(update)) {
                    return true;
                }
                if ((!regexCommands.isEmpty()) && handleRegexCommands(update)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean handleTextCommands(@NotNull Update update) {
        final var message = update.getMessage();
        final var args = message.getText().split("\\s+", 2);
        final var command = stringToCommand(args[0]);
        final var commands = Stream.ofNullable(textCommands.get(command))
                .flatMap(Collection::stream)
                .filter(cmd -> authority.hasRights(update, message.getFrom(), cmd.authority()))
                .collect(Collectors.toList());
        if (commands.isEmpty()) {
            return false;
        }

        final MessageContext context = new MessageContextBuilder()
                .setSender(handler)
                .setUpdate(update)
                .setUser(message.getFrom())
                .setChatId(message.getChatId())
                .setText(args.length >= 2 ? args[1] : "")
                .createMessageContext();
        for (TextCommand cmd : commands) {
            cmd.accept(context);
        }
        return true;
    }

    protected boolean handleRegexCommands(@NotNull Update update) {
        final var message = update.getMessage();
        final var text = message.getText();
        final long count = regexCommands.stream()
                .map(cmd -> Map.entry(cmd, cmd.pattern().matcher(text)))
                .filter(e -> e.getValue().find())
                .filter(e -> authority.hasRights(update, message.getFrom(), e.getKey().authority()))
                .map(e -> Map.entry(e.getKey(), new MessageContextBuilder()
                        .setSender(handler)
                        .setUpdate(update)
                        .setUser(message.getFrom())
                        .setChatId(message.getChatId())
                        .setText(text)
                        .createRegexContext(e.getValue())))
                .peek(e -> e.getKey().accept(e.getValue()))
                .count();
        return (count > 0);
    }

    protected String stringToCommand(String str) {
        return str.toLowerCase(Locale.ENGLISH).replace(botUsername, "");
    }
}
