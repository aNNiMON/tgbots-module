package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.beans.Config;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.webhook.DefaultTelegramWebhookBot;
import org.telegram.telegrambots.webhook.TelegramBotsWebhookApplication;
import org.telegram.telegrambots.webhook.WebhookOptions;

class RunnerWebHook {
    private static final Logger log = LoggerFactory.getLogger(RunnerWebHook.class);

    @SuppressWarnings("resource")
    void init(@NotNull Config config, @NotNull List<? extends BotModule> botModules) {
        try {
            // Configure local server
            final var wh = config.getWebhook();
            final var webhook = WebhookOptions.builder()
                    .useHttps(false)
                    .port(wh.getPort())
                    .enableRequestLogging("DEBUG".equals(config.getLogLevel()))
                    .build();
            final Predicate<String> nullOrBlank = s -> (s == null) || (s.isEmpty());
            if (!nullOrBlank.test(wh.getKeystorePath()) && wh.getKeystorePassword() != null) {
                webhook.setUseHttps(wh.getExternalUrl().startsWith("https"));
                webhook.setKeyStorePath(wh.getKeystorePath());
                webhook.setKeyStorePassword(wh.getKeystorePassword());
            }

            // Configure bot modules
            final var telegramBotsApi = new TelegramBotsWebhookApplication(webhook);
            for (var module : botModules) {
                try {
                    // Make sure to call botHandler first to init bots
                    final var bot = module.botHandler(config);

                    // Init SetWebhook
                    final var webhookBuilder = SetWebhook.builder()
                            .url(wh.getExternalUrl());
                    // Optional public key file for self-signed certificate
                    Optional.ofNullable(wh.getCertificatePublicKeyPath())
                            .filter(s -> !s.isEmpty())
                            .map(File::new)
                            .filter(f -> f.exists() && f.canRead())
                            .map(InputFile::new)
                            .ifPresent(webhookBuilder::certificate);
                    // Configure webhook (updates, max connections, etc.)
                    module.configureWebHook(webhookBuilder);
                    telegramBotsApi.registerBot(DefaultTelegramWebhookBot.builder()
                            .botPath(wh.getExternalUrl())
                            .setWebhook(() -> bot.setWebhook(webhookBuilder.build()))
                            .deleteWebhook(bot::clearWebhook)
                            .updateHandler(bot::onWebhookUpdateReceived)
                            .build());
                } catch (TelegramApiException ex) {
                    log.error("register webhook bot: " + module, ex);
                }
            }
        } catch (TelegramApiException e) {
            log.error("init webhook bot", e);
        }
    }
}
