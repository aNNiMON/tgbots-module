package com.annimon.tgbotsmodule;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.util.WebhookUtils;

public abstract class BotHandler extends TelegramWebhookBot implements LongPollingBot {

    public BotHandler() {
        this(ApiContext.getInstance(DefaultBotOptions.class));
    }

    public BotHandler(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public void onUpdateReceived(Update update) {
        onUpdate(update);
    }

    @Override
    public BotApiMethod onWebhookUpdateReceived(Update update) {
        return onUpdate(update);
    }

    public abstract BotApiMethod onUpdate(Update update);

    @Override
    public String getBotPath() {
        return getBotUsername();
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {
        WebhookUtils.clearWebhook(this);
    }

    @Override
    public void onClosing() {
        exe.shutdown();
    }
}