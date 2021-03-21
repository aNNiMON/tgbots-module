package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.beans.Config;
import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultWebhook;

public class Runner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        final var profile = (args.length >= 1 && !args[0].isEmpty()) ? args[0] : "";
        final var runner = new Runner(profile);
        runner.loadConfig();
        runner.initAll();
    }

    /**
     * Run with the default profile.
     *
     * @param modules  the list of the BotModule instances
     */
    public static void run(@NotNull List<? extends BotModule> modules) {
        run("", modules);
    }

    /**
     * Run with the given profile.
     * Profiles affect the config file name ("config-profile.yaml", default is "config.yaml")
     * @param profile  the profile name, leave empty for default
     * @param modules  the list of the BotModule instances
     */
    public static void run(@NotNull String profile,
                           @NotNull List<? extends BotModule> modules) {
        final var runner = new Runner(profile);
        runner.loadConfig();
        runner.init(modules.stream());
    }

    private final String profile;
    private final YamlConfigLoaderService configLoader;
    private Config config;

    private Runner(@NotNull String profile) {
        this.profile = profile;
        configLoader = new YamlConfigLoaderService();
    }

    private void initAll() {
        init(config.getModules()
                .stream()
                .map(this::moduleInstance));
    }

    private void init(@NotNull Stream<? extends BotModule> modulesStream) {
        // Remove nullable modules
        final var modules = modulesStream
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (modules.isEmpty()) {
            log.info("No modules found. Exiting…");
            return;
        }
        if (config.isWebHookEnabled()) {
            initWebHook(modules);
        } else {
            initLongPolling(modules);
        }
    }

    private void initWebHook(@NotNull List<@NotNull ? extends BotModule> botModules) {
        final Predicate<String> nullOrBlank = s -> (s == null) || (s.isEmpty());
        try {
            // Configure local server
            final var wh = config.getWebhook();
            final var webhook = new DefaultWebhook();
            webhook.setInternalUrl(wh.getInternalUrl());
            if (!nullOrBlank.test(wh.getKeystorePath()) && wh.getKeystorePassword() != null) {
                webhook.setKeyStore(wh.getKeystorePath(), wh.getKeystorePassword());
            }

            // Configure bot modules
            final var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class, webhook);
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
                    // Configure webhook (updates, max connections, etc)
                    module.configureWebHook(webhookBuilder);
                    telegramBotsApi.registerBot(bot, webhookBuilder.build());
                } catch (TelegramApiException ex) {
                    log.error("register webhook bot", ex);
                }
            }
        } catch (TelegramApiException e) {
            log.error("init webhook bot", e);
        }
    }

    private void initLongPolling(@NotNull List<@NotNull ? extends BotModule> botModules) {
        try {
            final var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            for (var module : botModules) {
                try {
                    telegramBotsApi.registerBot(module.botHandler(config));
                } catch (TelegramApiException ex) {
                    log.error("register long polling bot", ex);
                }
            }
        } catch (TelegramApiException ex) {
            log.error("init long polling bot", ex);
        }
    }

    private void loadConfig() {
        config = loadConfigFromResource()
                .or(this::loadConfigFromFile)
                .orElse(Config.defaultConfig());
        config.setProfile(profile);
    }

    private Optional<Config> loadConfigFromResource() {
        try {
            var path = configLoader.configResource("/config", profile);
            if (path != null) {
                return Optional.of(configLoader.loadResource(path, Config.class));
            }
        } catch (ConfigLoaderException cle) {
            log.info("Unable to load config from resource. Trying to load from file…");
        }
        return Optional.empty();
    }

    private Optional<Config> loadConfigFromFile() {
        try {
            var path = configLoader.configFile("config", profile);
            return Optional.of(configLoader.loadFile(path, Config.class));
        } catch (ConfigLoaderException cle) {
            log.info("Unable to load config file. Switch to default configuration.");
        }
        return Optional.empty();
    }

    @Nullable
    private BotModule moduleInstance(@NotNull String className) {
        try {
            return (BotModule) Class
                    .forName(className)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception ex) {
            log.warn("Unable to load module " + className);
            return null;
        }
    }
}