package com.annimon.tgbotsmodule.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public interface ConfigLoaderService<T> {

    default @NotNull T load(@NotNull File file, @NotNull Class<T> configType) {
        return load(file, configType, true, null);
    }

    default @NotNull T load(@NotNull File file, @NotNull Class<T> configType, boolean validate) {
        return load(file, configType, validate, null);
    }

    @NotNull T load(@NotNull File file, @NotNull Class<T> configType,
                    boolean validate, Consumer<ObjectMapper> mapperConsumer);

    @NotNull
    File configFile(@NotNull String baseName, @NotNull String profile);
}
