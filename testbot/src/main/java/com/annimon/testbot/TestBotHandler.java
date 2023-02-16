package com.annimon.testbot;

import com.annimon.testbot.commands.CalcBundle;
import com.annimon.testbot.commands.LocalizationBundle;
import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.commands.CommandRegistry;
import com.annimon.tgbotsmodule.commands.SimpleCommand;
import com.annimon.tgbotsmodule.commands.SimpleRegexCommand;
import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.authority.SimpleAuthority;
import com.annimon.tgbotsmodule.commands.context.MessageContext;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TestBotHandler extends BotHandler {

    private final BotConfig botConfig;
    private final CommandRegistry<For> commands;

    public TestBotHandler(BotConfig botConfig) {
        super(botConfig.getToken());
        this.botConfig = botConfig;

        final var authority = new SimpleAuthority(this, botConfig.getCreatorId());
        commands = new CommandRegistry<>(getBotUsername(), authority);

        commands.register(new SimpleCommand("/action", For.CREATOR, ctx -> {
            if (ctx.argumentsLength() != 1) return;
            Methods.sendChatAction(ctx.chatId(), ActionType.get(ctx.argument(0, "typing")))
                    .callAsync(ctx.sender);
        }));
        commands.register(new SimpleCommand("/reverse", ctx -> {
            ctx.reply(new StringBuilder(ctx.argumentsAsString()).reverse().toString())
                    .callAsync(ctx.sender);
        }));
        commands.register(new SimpleCommand("/fillrect", For.all(), this::fillRectInterpreter));

        commands.register(new SimpleRegexCommand(Pattern.compile("^/repeat (.*?) (\\d{1,2})$"), ctx -> {
            ctx.reply(ctx.group(1).repeat(Integer.parseInt(ctx.group(2))))
                    .callAsync(ctx.sender);
        }));

        commands.registerBundle(new LocalizationBundle());
        commands.registerBundle(new CalcBundle());

        addMethodPreprocessor(SendMessage.class, m -> {
            m.setAllowSendingWithoutReply(true);
            m.disableWebPagePreview();
        });
        addMethodPreprocessor(SendPhoto.class, m -> {
            m.setProtectContent(true);
        });
        addMethodPreprocessor(EditMessageText.class, EditMessageText::disableWebPagePreview);
    }

    @Override
    public BotApiMethod<?> onUpdate(@NotNull Update update) {
        if (commands.handleUpdate(update, this)) {
            return null;
        }
        // handle other updates
        return null;
    }

    private void fillRectInterpreter(MessageContext ctx) {
        final int w = 200, h = 200;
        var image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        var g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.BLACK);
        final var statements = ctx.argumentsAsString().toLowerCase().split(";");
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
}
