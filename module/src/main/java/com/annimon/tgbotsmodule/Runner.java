package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.beans.Config;
import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
                .toList();
        if (modules.isEmpty()) {
            log.info("No modules found. Exiting…");
            return;
        }
        if (config.isWebHookEnabled()) {
            new RunnerWebHook().init(config, modules);
        } else {
            new RunnerLongPolling().init(config, modules);
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
            log.info("Unable to load a config from resource for profile " + profile
                    + ". Trying to load from file…", cle);
        }
        return Optional.empty();
    }

    private Optional<Config> loadConfigFromFile() {
        try {
            var path = configLoader.configFile("config", profile);
            return Optional.of(configLoader.loadFile(path, Config.class));
        } catch (ConfigLoaderException cle) {
            log.info("Unable to load a config file for profile " + profile
                    + ". Switching to default configuration.", cle);
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
            log.warn("Unable to load module {}", className);
            return null;
        }
    }
}