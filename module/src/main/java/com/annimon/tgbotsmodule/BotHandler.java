package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.generics.WebhookBot;
import org.telegram.telegrambots.util.WebhookUtils;

public abstract class BotHandler extends CommonAbsSender
        implements LongPollingBot, WebhookBot {

    public BotHandler() {
        this(ApiContext.getInstance(DefaultBotOptions.class));
    }

    public BotHandler(@NotNull DefaultBotOptions options) {
        super(options);
    }

    @Override
    public void onUpdateReceived(@NotNull Update update) {
        onUpdate(update);
    }

    @Nullable
    @Override
    public BotApiMethod onWebhookUpdateReceived(@NotNull Update update) {
        return onUpdate(update);
    }

    @Nullable
    public abstract BotApiMethod onUpdate(@NotNull Update update);

    @Override
    public String getBotPath() {
        return getBotUsername();
    }

    @Override
    public void setWebhook(String url, String publicCertificatePath) throws TelegramApiRequestException {
        WebhookUtils.setWebhook(this, url, publicCertificatePath);
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