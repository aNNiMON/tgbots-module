package com.annimon.testbot;

import com.annimon.tgbotsmodule.BotHandler;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TestBotHandler extends BotHandler {

    private final BotConfig botConfig;

    public TestBotHandler(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public BotApiMethod onUpdate(Update update) {
        final var message = update.getMessage();
        if (update.hasMessage() && message.hasText()) {
            call(new SendMessage()
                    .setChatId(message.getChatId())
                    .setText(new StringBuilder(message.getText()).reverse().toString()));
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
