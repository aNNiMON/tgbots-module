package com.annimon.testbot;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.BotModule;
import com.annimon.tgbotsmodule.Runner;
import com.annimon.tgbotsmodule.beans.Config;
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TestBot implements BotModule {

    public static void main(String[] args) {
        final var profile = (args.length >= 1 && !args[0].isEmpty()) ? args[0] : "";
        Runner.run(profile, List.of(new TestBot()));
    }

    @Override
    public @NotNull BotHandler botHandler(Config config) {
        final var configLoader = new YamlConfigLoaderService();
        final var configFile = configLoader.configFile("testbot", config.getProfile());
        final var botConfig = configLoader.loadFile(configFile, BotConfig.class);
        return new TestBotHandler(botConfig);
    }
}
