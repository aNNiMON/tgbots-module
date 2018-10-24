package com.annimon.tgbotsmodule.services;

import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.validation.Validation;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.logging.BotLogger;

public class YamlConfigLoaderService<T> implements ConfigLoaderService<T> {

    private static final String LOGTAG = YamlConfigLoaderService.class.getName();

    @NotNull
    @Override
    public File configFile(@NotNull String baseName, @NotNull String profile) {
        final Predicate<File> validFile = f -> f.exists() && f.canRead();
        File file;
        if (!profile.isEmpty()) {
            file = new File(baseName + "-" + profile + ".yaml");
            if (validFile.test(file)) {
                return file;
            }
        }
        file = new File(baseName + ".yaml");
        if (validFile.test(file)) {
            return file;
        }
        throw new ConfigLoaderException("No " + baseName + ".yaml file");
    }

    @NotNull
    @Override
    public T load(@NotNull File file, @NotNull Class<T> configType, boolean validate) {
        final var mapper = new ObjectMapper(new YamlConfigFactory());
        mapper.registerModule(new KotlinModule());
        try {
            var config = mapper.readValue(file, configType);
            if (validate) {
                validate(config);
            }
            return config;
        } catch (IOException ex) {
            BotLogger.error(LOGTAG, ex);
            throw new ConfigLoaderException(ex);
        }
    }

    private void validate(T config) {
        final var factory = Validation.buildDefaultValidatorFactory();
        final var violations = factory.getValidator().validate(config);
        if (!violations.isEmpty()) {
            String description = violations.stream()
                    .map(cv -> String.format("Config property %s %s", cv.getPropertyPath(), cv.getMessage()))
                    .collect(Collectors.joining("\n"));
            throw new ConfigLoaderException(description);
        }
    }
}