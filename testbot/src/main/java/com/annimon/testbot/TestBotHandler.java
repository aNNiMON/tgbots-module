package com.annimon.testbot;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.commands.CommandRegistry;
import com.annimon.tgbotsmodule.commands.SimpleCommand;
import com.annimon.tgbotsmodule.commands.SimpleRegexCommand;
import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.authority.SimpleAuthority;
import com.annimon.tgbotsmodule.commands.context.MessageContext;
import com.annimon.tgbotsmodule.commands.context.RegexMessageContext;
import com.annimon.tgbotsmodule.services.LocalizationService;
import com.annimon.tgbotsmodule.services.ResourceBundleLocalizationService;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class TestBotHandler extends BotHandler {

    private final BotConfig botConfig;
    private final CommandRegistry commands;
    private final SimpleAuthority authority;

    private String globalLocale;
    private final LocalizationService localization;

    public TestBotHandler(BotConfig botConfig) {
        this.botConfig = botConfig;

        authority = new SimpleAuthority(this, botConfig.getCreatorId());
        commands = new CommandRegistry(this, authority);

        globalLocale = "en";
        localization = new ResourceBundleLocalizationService("Language");

        commands.register(new SimpleCommand("/action", For.CREATOR, ctx -> {
            if (ctx.argumentsLength() != 1) return;
            Methods.sendChatAction(ctx.chatId(), ActionType.get(ctx.argument(0, "typing")))
                    .callAsync(ctx.sender);
        }));
        commands.register(new SimpleCommand("/reverse", ctx -> {
            ctx.reply(new StringBuilder(ctx.text()).reverse().toString())
                    .callAsync(ctx.sender);
        }));
        commands.register(new SimpleCommand("/fillrect", For.ALL, this::fillRectInterpreter));

        commands.register(new SimpleRegexCommand(
                "^/calc (-?\\d{1,20}) ?([+\\-*/]) ?(-?\\d{1,20})$", this::calcCommand));

        commands.register(new SimpleRegexCommand(Pattern.compile("^/repeat (.*?) (\\d{1,2})$"), ctx -> {
            ctx.reply(ctx.group(1).repeat(Integer.parseInt(ctx.group(2))))
                    .callAsync(ctx.sender);
        }));

        // Locale
        commands.register(new SimpleCommand("/hello_global", ctx -> {
            // Sends hello message according to global locale
            ctx.reply(localization.getString("hello", globalLocale)).callAsync(ctx.sender);
        }));
        commands.register(new SimpleCommand("/hello_local", ctx -> {
            // Sends hello message according to user language code
            final var userLocale = Optional.ofNullable(ctx.user().getLanguageCode()).orElse(globalLocale);
            ctx.reply(localization.getString("hello", userLocale)).callAsync(ctx.sender);
        }));
        commands.register(new SimpleCommand("/switch_language", ctx -> {
            // Setup inline keyboard
            final var keyboard = new ArrayList<List<InlineKeyboardButton>>(2);
            for (var lang : List.of("en", "ru")) {
                var languageName = localization.getString("lang_" + lang, globalLocale);
                var btn = new InlineKeyboardButton(languageName).setCallbackData(lang);
                keyboard.add(List.of(btn));
            }

            ctx.reply(localization.getString("choose_language", globalLocale))
                    .setReplyMarkup(new InlineKeyboardMarkup().setKeyboard(keyboard))
                    .callAsync(ctx.sender);
        }));
    }

    @Override
    public BotApiMethod onUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            // Switch global language
            final var message = update.getCallbackQuery().getMessage();
            if (message != null) {
                final String callbackData = update.getCallbackQuery().getData();
                globalLocale = Optional.ofNullable(callbackData).orElse("en");
                Methods.editMessageText()
                        .setChatId(message.getChatId())
                        .setMessageId(message.getMessageId())
                        .setText(localization.getString("language_set", globalLocale))
                        .callAsync(this);
            }
            return null;
        }
        if (commands.handleUpdate(update)) {
            return null;
        }
        // handle other updates
        return null;
    }

    private void calcCommand(RegexMessageContext ctx) {
        var value1 = new BigInteger(ctx.group(1));
        var value2 = new BigInteger(ctx.group(3));
        String result = String.format("%s %s %s = ", value1, value2, ctx.group(3));
        switch (ctx.group(2)) {
            case "+": result += value1.add(value2); break;
            case "-": result += value1.subtract(value2); break;
            case "*": result += value1.multiply(value2); break;
            case "/":
                if (value2.compareTo(BigInteger.ZERO) == 0) result += "error";
                else result += value1.divide(value2); break;
            default: return;
        }
        ctx.reply(result)
                .setReplyToMessageId(ctx.message().getMessageId())
                .callAsync(ctx.sender);
    }

    private void fillRectInterpreter(MessageContext ctx) {
        final int w = 200, h = 200;
        var image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        var g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.BLACK);
        final var statements = ctx.text().toLowerCase().split(";");
        for (var statement : statements) {
            final var p = statement.replaceAll("[(),]", " ").trim().replaceAll("\\s+", " ").split(" ");
            switch (p[0].trim()) {
                case "color":
                case "setcolor":
                    if (p.length >= 4) {
                        g.setColor(new Color(intval(p[1]), intval(p[2]), intval(p[3])));
                    } else if (p.length >= 2) {
                        g.setColor(new Color(intval(p[1], 16)));
                    }
                    break;
                case "rect":
                case "fillrect":
                    if (p.length >= 5) {
                        g.fillRect(intval(p[1]), intval(p[2]), intval(p[3]), intval(p[4]));
                    }
                    break;
            }
        }
        try {
            final var file = File.createTempFile("_fillrect", ".png");
            ImageIO.write(image, "png", file);
            ctx.replyWithPhoto()
                    .setFile(file)
                    .callAsync(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int intval(String s) {
        return intval(s, 10);
    }

    private int intval(String s, int radix) {
        try {
            return Integer.parseInt(s, radix);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}
