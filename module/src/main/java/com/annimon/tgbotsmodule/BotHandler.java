package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.generics.WebhookBot;
import org.telegram.telegrambots.util.WebhookUtils;

public abstract class BotHandler extends CommonAbsSender
        implements LongPollingBot, WebhookBot {

    public BotHandler(@NotNull String botToken) {
        this(new DefaultBotOptions(), botToken);
    }

    public BotHandler(@NotNull DefaultBotOptions options, @NotNull String botToken) {
        super(options, botToken);
    }

    @Override
    public void onUpdateReceived(@NotNull Update update) {
        onUpdate(update);
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(@NotNull Update update) {
        return onUpdate(update);
    }

    protected abstract BotApiMethod<?> onUpdate(@NotNull Update update);

    @Override
    public String getBotPath() {
        return getBotUsername();
    }

    @Override
    public void setWebhook(SetWebhook setWebhook) throws TelegramApiException {
        WebhookUtils.setWebhook(this, this, setWebhook);
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