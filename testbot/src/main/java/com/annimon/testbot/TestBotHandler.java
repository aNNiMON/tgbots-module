package com.annimon.testbot;

import com.annimon.tgbotsmodule.BotHandler;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.logging.BotLogger;

public class TestBotHandler extends BotHandler {

    private static final String LOGTAG = TestBotHandler.class.getName();

    private final BotConfig botConfig;

    public TestBotHandler(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public BotApiMethod onUpdate(Update update) {
        final var message = update.getMessage();
        if (update.hasMessage() && message.hasText()) {
            try {
                execute(new SendMessage()
                        .setChatId(message.getChatId())
                        .setText(new StringBuilder(message.getText()).reverse().toString()));
            } catch (TelegramApiException ex) {
                BotLogger.error(LOGTAG, ex);
            }
        }
        return null;
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
