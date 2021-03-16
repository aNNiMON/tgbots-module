package com.annimon.testbot.commands;

import com.annimon.tgbotsmodule.commands.CommandBundle;
import com.annimon.tgbotsmodule.commands.CommandRegistry;
import com.annimon.tgbotsmodule.commands.SimpleInlineQueryCommand;
import com.annimon.tgbotsmodule.commands.SimpleRegexCommand;
import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.context.InlineQueryContext;
import com.annimon.tgbotsmodule.commands.context.RegexMessageContext;
import java.math.BigInteger;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResultArticle;

public class CalcBundle implements CommandBundle<For> {

    private static final String CALC_REGEX = "(-?\\d{1,20}) ?([+\\-*/]) ?(-?\\d{1,20})$";

    @Override
    public void register(@NotNull CommandRegistry<For> commands) {
        commands.register(new SimpleRegexCommand("^/calc " + CALC_REGEX, this::calcCommand));
        commands.register(new SimpleInlineQueryCommand("calc", this::calcInline));
    }

    private void calcCommand(RegexMessageContext ctx) {
        var value1 = new BigInteger(ctx.group(1));
        var value2 = new BigInteger(ctx.group(3));
        String result = getResult(value1, ctx.group(2), value2);
        if (result != null) {
            ctx.replyToMessage(result).callAsync(ctx.sender);
        } else {
            ctx.replyToMessage(unrecognizedMessage())
                    .enableMarkdown()
                    .callAsync(ctx.sender);
        }
    }

    private void calcInline(InlineQueryContext ctx) {
        final var m = Pattern.compile(CALC_REGEX).matcher(ctx.argumentsAsString());
        if (!m.find()) {
            ctx.answer(unrecognizedArticle()).callAsync(ctx.sender);
            return;
        }

        var value1 = new BigInteger(m.group(1));
        var value2 = new BigInteger(m.group(3));
        String result = getResult(value1, m.group(2), value2);
        if (result == null) {
            ctx.answer(unrecognizedArticle()).callAsync(ctx.sender);
        } else {
            ctx.answerArticle(
                    "calc_" + result.hashCode(),
                    result,
                    InputTextMessageContent.builder()
                            .messageText("Result:\n `" + result + "`")
                            .parseMode(ParseMode.MARKDOWN)
                            .build())
                    .callAsync(ctx.sender);
        }
    }

    @Nullable
    private String getResult(BigInteger value1, String op, BigInteger value2) {
        String result = "";
        switch (op) {
            case "+": result += value1.add(value2); break;
            case "-": result += value1.subtract(value2); break;
            case "*": result += value1.multiply(value2); break;
            case "/":
                if (value2.compareTo(BigInteger.ZERO) == 0) result += "error";
                else result += value1.divide(value2); break;
            default:
                return null;
        }
        return String.format("%s %s %s = %s", value1, op, value2, result);
    }

    private InlineQueryResultArticle unrecognizedArticle() {
        return new InlineQueryResultArticle(
                "calc_unrecognized",
                "Unrecognized format",
                InputTextMessageContent.builder()
                        .messageText(unrecognizedMessage())
                        .parseMode(ParseMode.MARKDOWN)
                        .build());
    }

    @NotNull
    private String unrecognizedMessage() {
        return "Unrecognized query format.\n" +
                "Use format: `calc num1 operation num2`\n" +
                "Allowed operations is: `+`, `-`, `*`, and `/`\n" +
                "Example: `calc 123+456`";
    }
}
