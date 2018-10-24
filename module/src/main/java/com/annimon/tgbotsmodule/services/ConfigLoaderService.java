package com.annimon.tgbotsmodule.services;

import java.io.File;
import org.jetbrains.annotations.NotNull;

public interface ConfigLoaderService<T> {

    @NotNull
    default T load(@NotNull File file, @NotNull Class<T> configType) {
        return load(file, configType, true);
    }

    @NotNull
    T load(@NotNull File file, @NotNull Class<T> configType, boolean validate);

    @NotNull
    File configFile(@NotNull String baseName, @NotNull String profile);
}
