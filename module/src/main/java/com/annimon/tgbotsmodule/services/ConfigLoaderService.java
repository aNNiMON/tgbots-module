package com.annimon.tgbotsmodule.services;

import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public interface ConfigLoaderService<T> {

    default @NotNull T load(@NotNull File file, @NotNull Class<T> configType) {
        return load(file, configType, null);
    }

    @NotNull T load(@NotNull File file, @NotNull Class<T> configType,
                    Consumer<ObjectMapper> mapperConsumer);

    default @NotNull T load(@NotNull String resourcePath, @NotNull Class<T> configType) {
        return load(resourcePath, configType, null);
    }

    default @NotNull T load(@NotNull String resourcePath, @NotNull Class<T> configType,
                            Consumer<ObjectMapper> mapperConsumer) {
        try (var is = getClass().getResourceAsStream(resourcePath)) {
            return load(is, configType, mapperConsumer);
        } catch (IOException ex) {
            throw new ConfigLoaderException(ex);
        }
    }

    default @NotNull T load(@NotNull InputStream is, @NotNull Class<T> configType) {
        return load(is, configType, null);
    }

    @NotNull T load(@NotNull InputStream is, @NotNull Class<T> configType,
                    Consumer<ObjectMapper> mapperConsumer);

    @NotNull
    File configFile(@NotNull String baseName, @NotNull String profile);
}
