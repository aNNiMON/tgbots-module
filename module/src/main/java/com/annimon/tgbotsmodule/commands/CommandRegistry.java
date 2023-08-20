package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.analytics.UpdateHandler;
import com.annimon.tgbotsmodule.commands.authority.Authority;
import com.annimon.tgbotsmodule.commands.context.CallbackQueryContext;
import com.annimon.tgbotsmodule.commands.context.InlineQueryContext;
import com.annimon.tgbotsmodule.commands.context.MessageContext;
import com.annimon.tgbotsmodule.commands.context.RegexMessageContext;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;

@SuppressWarnings("RedundantIfStatement")
public class CommandRegistry<TRole extends Enum<TRole>> implements UpdateHandler {

    private final String botUsername;
    private final ListMultimap<String, TextCommand> textCommands;
    private final List<RegexCommand> regexCommands;
    private final ListMultimap<String, CallbackQueryCommand> callbackCommands;
    private final ListMultimap<String, InlineQueryCommand> inlineCommands;
    private final Authority<TRole> authority;

    private String callbackCommandSplitPattern;

    public CommandRegistry(@NotNull String botUsername, @NotNull Authority<TRole> authority) {
        this.authority = authority;
        this.botUsername = "@" + botUsername.toLowerCase(Locale.ENGLISH);
        textCommands = ArrayListMultimap.create();
        regexCommands = new ArrayList<>();
        callbackCommands = ArrayListMultimap.create();
        inlineCommands = ArrayListMultimap.create();

        callbackCommandSplitPattern = ":";
    }

    public CommandRegistry<TRole> register(@NotNull TextCommand command) {
        Objects.requireNonNull(command);
        Stream.concat(Stream.of(command.command()), command.aliases().stream())
                .map(this::stringToCommand)
                .forEach(key -> textCommands.put(key, command));
        return this;
    }

    public CommandRegistry<TRole> register(@NotNull RegexCommand command) {
        Objects.requireNonNull(command);
        regexCommands.add(command);
        return this;
    }

    public CommandRegistry<TRole> register(@NotNull CallbackQueryCommand command) {
        Objects.requireNonNull(command);
        callbackCommands.put(command.command(), command);
        return this;
    }

    public CommandRegistry<TRole> register(@NotNull InlineQueryCommand command) {
        Objects.requireNonNull(command);
        inlineCommands.put(command.command(), command);
        return this;
    }

    public CommandRegistry<TRole> registerBundle(@NotNull CommandBundle<TRole> bundle) {
        Objects.requireNonNull(bundle);
        bundle.register(this);
        return this;
    }

    /**
     * Splits {@code callback.data} by whitespace ({@code "cmd:args"})
     * @return this
     */
    public CommandRegistry<TRole> splitCallbackCommandByColon() {
        return splitCallbackCommandByPattern(":");
    }

    /**
     * Splits {@code callback.data} by whitespace ({@code "cmd args"})
     * @return this
     */
    public CommandRegistry<TRole> splitCallbackCommandByWhitespace() {
        return splitCallbackCommandByPattern("\\s+");
    }

    /**
     * Treats whole {@code callback.data} as command ({@code "cmd"})
     * @return this
     */
    public CommandRegistry<TRole> doNotSplitCallbackCommands() {
        return splitCallbackCommandByPattern("$");
    }

    public CommandRegistry<TRole> splitCallbackCommandByPattern(@NotNull String pattern) {
        this.callbackCommandSplitPattern = Objects.requireNonNull(pattern);
        return this;
    }

    @Override
    public boolean handleUpdate(@NotNull CommonAbsSender sender, @NotNull Update update) {
        if (update.hasMessage()) {
            // Text commands
            if (update.getMessage().hasText()) {
                if ((!textCommands.isEmpty()) && handleTextCommands(sender, update)) {
                    return true;
                }
                if ((!regexCommands.isEmpty()) && handleRegexCommands(sender, update)) {
                    return true;
                }
            }
        } else if (update.hasCallbackQuery()) {
            // Callback query commands
            final var data = update.getCallbackQuery().getData();
            if (data != null && !data.isEmpty()) {
                if ((!callbackCommands.isEmpty()) && handleCallbackQueryCommands(sender, update)) {
                    return true;
                }
            }
        } else if (update.hasInlineQuery()) {
            // Inline query commands
            if ((!inlineCommands.isEmpty()) && handleInlineQueryCommands(sender, update)) {
                return true;
            }
        }
        return false;
    }

    protected boolean handleTextCommands(@NotNull CommonAbsSender sender, @NotNull Update update) {
        final var message = update.getMessage();
        final var args = message.getText().split("\\s+", 2);
        final var command = stringToCommand(args[0]);
        final var commands = Stream.ofNullable(textCommands.get(command))
                .flatMap(Collection::stream)
                .filter(cmd -> authority.hasRights(sender, update, message.getFrom(), cmd.authority()))
                .collect(Collectors.toList());
        if (commands.isEmpty()) {
            return false;
        }

        final var commandArguments = args.length >= 2 ? args[1] : "";
        final var context = new MessageContext(sender, update, commandArguments);
        for (TextCommand cmd : commands) {
            cmd.accept(context);
        }
        return true;
    }

    protected boolean handleRegexCommands(@NotNull CommonAbsSender sender, @NotNull Update update) {
        final var message = update.getMessage();
        final var text = message.getText();
        final long count = regexCommands.stream()
                .map(cmd -> Map.entry(cmd, cmd.pattern().matcher(text)))
                .filter(e -> e.getValue().find())
                .filter(e -> authority.hasRights(sender, update, message.getFrom(), e.getKey().authority()))
                .peek(e -> {
                    final RegexCommand command = e.getKey();
                    final var matcher = e.getValue();
                    command.accept(new RegexMessageContext(sender, update, text, matcher));
                })
                .count();
        return (count > 0);
    }

    protected boolean handleCallbackQueryCommands(@NotNull CommonAbsSender sender, @NotNull Update update) {
        final var query = update.getCallbackQuery();
        final var args = query.getData().split(callbackCommandSplitPattern, 2);
        final var command = args[0];
        final var commands = Stream.ofNullable(callbackCommands.get(command))
                .flatMap(Collection::stream)
                .filter(cmd -> authority.hasRights(sender, update, query.getFrom(), cmd.authority()))
                .collect(Collectors.toList());
        if (commands.isEmpty()) {
            return false;
        }

        final var commandArguments = args.length >= 2 ? args[1] : "";
        final var context = new CallbackQueryContext(sender, update, commandArguments);
        for (CallbackQueryCommand cmd : commands) {
            cmd.accept(context);
        }
        return true;
    }

    private boolean handleInlineQueryCommands(@NotNull CommonAbsSender sender, @NotNull Update update) {
        final var inlineQuery = update.getInlineQuery();
        final var query = inlineQuery.getQuery();
        final var args = query.split("\\s+", 2);
        final var command = args[0];
        final var commands = Stream.ofNullable(inlineCommands.get(command))
                .flatMap(Collection::stream)
                .filter(cmd -> authority.hasRights(sender, update, inlineQuery.getFrom(), cmd.authority()))
                .collect(Collectors.toList());
        if (commands.isEmpty()) {
            return false;
        }

        final var commandArguments = args.length >= 2 ? args[1] : "";
        final var context = new InlineQueryContext(sender, update, commandArguments);
        for (InlineQueryCommand cmd : commands) {
            cmd.accept(context);
        }
        return true;
    }

    protected String stringToCommand(String str) {
        return str.toLowerCase(Locale.ENGLISH).replace(botUsername, "");
    }
}
