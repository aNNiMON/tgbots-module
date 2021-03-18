package com.annimon.tgbotsmodule.services;

import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public interface ConfigLoaderService {

    default <T> @NotNull T loadFile(
            @NotNull File file,
            @NotNull Class<T> configType) {
        return loadFile(file, configType, null);
    }

    <T> @NotNull T loadFile(
            @NotNull File file,
            @NotNull Class<T> configType,
            Consumer<ObjectMapper> mapperConsumer);

    default <T> @NotNull T loadResource(
            @NotNull String resourcePath,
            @NotNull Class<T> configType) {
        return loadResource(resourcePath, configType, null);
    }

    default <T> @NotNull T loadResource(
            @NotNull String resourcePath,
            @NotNull Class<T> configType,
            Consumer<ObjectMapper> mapperConsumer) {
        try (var is = getClass().getResourceAsStream(resourcePath)) {
            return load(is, configType, mapperConsumer);
        } catch (IOException ex) {
            throw new ConfigLoaderException(ex);
        }
    }

    default <T> @NotNull T load(
            @NotNull InputStream is,
            @NotNull Class<T> configType) {
        return load(is, configType, null);
    }

    <T> @NotNull T load(
            @NotNull InputStream is,
            @NotNull Class<T> configType,
            Consumer<ObjectMapper> mapperConsumer);

    @NotNull
    File configFile(@NotNull String baseName, @NotNull String profile);
}
