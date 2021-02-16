package com.annimon.tgbotsmodule.services;

import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jetbrains.annotations.NotNull;

public class YamlConfigLoaderService<T> implements ConfigLoaderService<T> {

    private static final Logger log = LoggerFactory.getLogger(YamlConfigLoaderService.class);

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

    @Override
    public @NotNull T load(@NotNull File file, @NotNull Class<T> configType,
                           Consumer<ObjectMapper> mapperConsumer) {
        final var mapper = new ObjectMapper(new YamlConfigFactory());
        if (mapperConsumer != null) {
            mapperConsumer.accept(mapper);
        }
        try {
            return mapper.readValue(file, configType);
        } catch (IOException ex) {
            log.error("yaml loader", ex);
            throw new ConfigLoaderException(ex);
        }
    }

    @Override
    public @NotNull T load(@NotNull InputStream is, @NotNull Class<T> configType,
                           Consumer<ObjectMapper> mapperConsumer) {
        final var mapper = new ObjectMapper(new YamlConfigFactory());
        if (mapperConsumer != null) {
            mapperConsumer.accept(mapper);
        }
        try {
            return mapper.readValue(is, configType);
        } catch (IOException ex) {
            log.error("yaml loader", ex);
            throw new ConfigLoaderException(ex);
        }
    }
}