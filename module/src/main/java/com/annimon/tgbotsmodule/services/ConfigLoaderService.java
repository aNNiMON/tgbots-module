package com.annimon.tgbotsmodule.services;

import java.io.File;

public interface ConfigLoaderService<T> {

    default T load(File file, Class<T> configType) {
        return load(file, configType, true);
    }

    T load(File file, Class<T> configType, boolean validate);

    File configFile(String baseName, String profile);
}
