package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.beans.Config;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

class RunnerLongPolling {
    private static final Logger log = LoggerFactory.getLogger(RunnerLongPolling.class);

    @SuppressWarnings("resource")
    void init(@NotNull Config config, @NotNull List<? extends BotModule> botModules) {
        try {
            final var telegramBotsApi = new TelegramBotsLongPollingApplication();
            for (var module : botModules) {
                try {
                    final BotHandler handler = module.botHandler(config);
                    final var options = handler.getBotModuleOptions();
                    telegramBotsApi.registerBot(
                            options.botToken(),
                            options.telegramUrlSupplier(),
                            options.getUpdatesGenerator(),
                            handler);
                } catch (TelegramApiException ex) {
                    log.error("register long polling bot: " + module, ex);
                }
            }
        } catch (Exception ex) {
            log.error("init long polling bot", ex);
        }
    }
}
