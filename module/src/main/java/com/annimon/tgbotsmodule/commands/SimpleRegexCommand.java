package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.context.RegexMessageContext;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class SimpleRegexCommand implements RegexCommand {

    private final Pattern pattern;
    private final Consumer<RegexMessageContext> contextConsumer;
    private final For authority;

    public SimpleRegexCommand(@NotNull String regex, @NotNull Consumer<RegexMessageContext> contextConsumer) {
        this(regex, For.ALL, contextConsumer);
    }

    public SimpleRegexCommand(@NotNull String regex, @NotNull For authority, @NotNull Consumer<RegexMessageContext> contextConsumer) {
        this(Pattern.compile(regex), authority, contextConsumer);
    }

    public SimpleRegexCommand(@NotNull Pattern pattern, @NotNull Consumer<RegexMessageContext> contextConsumer) {
        this(pattern, For.ALL, contextConsumer);
    }

    public SimpleRegexCommand(@NotNull Pattern pattern, @NotNull For authority, @NotNull Consumer<RegexMessageContext> contextConsumer) {
        this.pattern = pattern;
        this.contextConsumer = contextConsumer;
        this.authority = authority;
    }

    @Override
    public Pattern pattern() {
        return pattern;
    }

    @Override
    public For authority() {
        return authority;
    }

    @Override
    public void accept(@NotNull RegexMessageContext context) {
        contextConsumer.accept(context);
    }
}
