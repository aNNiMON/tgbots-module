package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.beans.Config;
import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.generics.WebhookBot;
import org.telegram.telegrambots.meta.logging.BotLogger;

public class Runner {

    private static final String LOGTAG = Runner.class.getName();

    public static void main(String[] args) {
        final var profile = (args.length >= 1 && !args[0].isEmpty()) ? args[0] : "";
        final var config = loadConfig(profile);
        BotLogger.setLevel(Level.parse(config.getLogLevel()));
        BotLogger.registerLogger(new ConsoleHandler());
        final var modules = config.getModules().stream()
                .map(Runner::moduleInstance)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        run(config, modules);
    }

    public static void run(@NotNull String profile,
                           @NotNull List<@Nullable BotModule> modules) {
        final var config = loadConfig(profile);
        run(config, modules.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }

    private static void run(@NotNull Config config,
                            @NotNull List<@NotNull BotModule> modules) {
        if (modules.isEmpty()) {
            BotLogger.info(LOGTAG, "No modules found. Exiting…");
            return;
        }
        ApiContextInitializer.init();
        if (config.isWebHookEnabled()) {
            initWebHook(config, modules);
        } else {
            initLongPolling(config, modules);
        }
    }

    private static void initWebHook(@NotNull Config config,
                                    @NotNull List<@NotNull BotModule> botModules) {
        final Predicate<String> nullOrBlank = s -> (s == null) || (s.isEmpty());
        final TelegramBotsApi telegramBotsApi;
        try {
            final var wh = config.getWebhook();
            if (nullOrBlank.test(wh.getCertificatePublicKeyPath())) {
                telegramBotsApi = new TelegramBotsApi(
                        wh.getCertificateStorePath(), wh.getCertificateStorePassword(),
                        wh.getExternalUrl(), wh.getInternalUrl());
            } else {
                // self-signed certificate
                telegramBotsApi = new TelegramBotsApi(
                        wh.getCertificateStorePath(), wh.getCertificateStorePassword(),
                        wh.getExternalUrl(), wh.getInternalUrl(),
                        wh.getCertificatePublicKeyPath());
            }
            for (var module : botModules) {
                try {
                    telegramBotsApi.registerBot((WebhookBot) module.botHandler(config));
                } catch (TelegramApiException ex) {
                    BotLogger.error(LOGTAG, ex);
                }
            }
        } catch (TelegramApiRequestException e) {
            BotLogger.error(LOGTAG, e);
        }
    }

    private static void initLongPolling(@NotNull Config config,
                                        @NotNull List<@NotNull BotModule> botModules) {
        final var telegramBotsApi = new TelegramBotsApi();
        for (var module : botModules) {
            try {
                telegramBotsApi.registerBot((LongPollingBot) module.botHandler(config));
            } catch (TelegramApiException ex) {
                BotLogger.error(LOGTAG, ex);
            }
        }
    }

    @NotNull
    private static Config loadConfig(@NotNull String profile) {
        final var configLoader = new YamlConfigLoaderService<Config>();
        var config = Config.defaultConfig();
        try {
            final var configFile = configLoader.configFile("config", profile);
            config = configLoader.load(configFile, Config.class);
        } catch (ConfigLoaderException cle) {
            BotLogger.info(LOGTAG, "Unable to load config file. Switch to default configuration.");
        }
        config.setProfile(profile);
        return config;
    }

    @Nullable
    private static BotModule moduleInstance(@NotNull String className) {
        try {
            return (BotModule) Class
                    .forName(className)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception ex) {
            BotLogger.warning(LOGTAG, "Unable to load module " + className);
            return null;
        }
    }
}