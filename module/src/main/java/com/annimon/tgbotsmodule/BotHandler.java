package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class BotHandler extends CommonAbsSender
        implements LongPollingUpdateConsumer {

    private final BotModuleOptions botModuleOptions;
    private final Executor updatesProcessorExecutor;

    public BotHandler(@NotNull BotModuleOptions botModuleOptions) {
        super(botModuleOptions.botToken());
        this.botModuleOptions = botModuleOptions;
        updatesProcessorExecutor = Executors.newSingleThreadExecutor();
    }

    @Override
    public void consume(List<Update> updates) {
        for (Update update : updates) {
            updatesProcessorExecutor.execute(() -> onUpdate(update));
        }
    }

    public BotApiMethod<?> onWebhookUpdateReceived(@NotNull Update update) {
        return onUpdate(update);
    }

    protected abstract BotApiMethod<?> onUpdate(@NotNull Update update);

    public void setWebhook(SetWebhook setWebhook) {
    }

    public void clearWebhook() {
    }

    public BotModuleOptions getBotModuleOptions() {
        return botModuleOptions;
    }
}