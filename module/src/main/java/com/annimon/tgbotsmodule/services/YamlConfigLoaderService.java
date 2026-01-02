package com.annimon.tgbotsmodule.services;

import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import java.io.File;
import java.io.InputStream;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jetbrains.annotations.NotNull;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.cfg.MapperBuilder;
import tools.jackson.dataformat.yaml.YAMLMapper;

public class YamlConfigLoaderService implements ConfigLoaderService {

    private static final Logger log = LoggerFactory.getLogger(YamlConfigLoaderService.class);

    @Override
    public <T> @NotNull T loadFile(
            @NotNull File file,
            @NotNull Class<T> configType,
            Consumer<MapperBuilder<? extends ObjectMapper, ?>> mapperConsumer) {
        final var mapper = getConfiguredMapper(mapperConsumer);
        try {
            return mapper.readValue(file, configType);
        } catch (JacksonException ex) {
            log.error("yaml loader", ex);
            throw new ConfigLoaderException(ex);
        }
    }

    @Override
    public <T> @NotNull T loadFile(
            @NotNull File file,
            @NotNull TypeReference<T> configType,
            Consumer<MapperBuilder<? extends ObjectMapper, ?>> mapperConsumer) {
        final var mapper = getConfiguredMapper(mapperConsumer);
        try {
            return mapper.readValue(file, configType);
        } catch (JacksonException ex) {
            log.error("yaml loader", ex);
            throw new ConfigLoaderException(ex);
        }
    }

    @Override
    public <T> @NotNull T load(
            @NotNull InputStream is,
            @NotNull Class<T> configType,
            Consumer<MapperBuilder<? extends ObjectMapper, ?>> mapperConsumer) {
        final var mapper = getConfiguredMapper(mapperConsumer);
        try {
            return mapper.readValue(is, configType);
        } catch (JacksonException ex) {
            log.error("yaml loader", ex);
            throw new ConfigLoaderException(ex);
        }
    }

    @Override
    public <T> @NotNull T load(
            @NotNull InputStream is,
            @NotNull TypeReference<T> configType,
            Consumer<MapperBuilder<? extends ObjectMapper, ?>> mapperConsumer) {
        final var mapper = getConfiguredMapper(mapperConsumer);
        try {
            return mapper.readValue(is, configType);
        } catch (JacksonException ex) {
            log.error("yaml loader", ex);
            throw new ConfigLoaderException(ex);
        }
    }

    @NotNull
    @Override
    public File configFile(@NotNull String baseName, @NotNull String profile) {
        return configCandidates(baseName, profile)
                .map(File::new)
                .filter(f -> f.exists() && f.canRead())
                .findFirst()
                .orElseThrow(() -> new ConfigLoaderException("No " + baseName + ".yaml file"));
    }

    public String configResource(@NotNull String baseName, @NotNull String profile) {
        return configCandidates(baseName, profile)
                .filter(path -> getClass().getResource(path) != null)
                .findFirst()
                .orElse(null);
    }

    private Stream<String> configCandidates(
            @NotNull String baseName, @NotNull String profile) {
        final var builder = Stream.<String>builder();
        if (!profile.isEmpty()) {
            builder.accept(baseName + "-" + profile + ".yaml");
        }
        builder.accept(baseName + ".yaml");
        return builder.build();
    }

    @NotNull
    private static ObjectMapper getConfiguredMapper(Consumer<MapperBuilder<? extends ObjectMapper, ?>> mapperConsumer) {
        final var mapper = YAMLMapper.builder(new YamlConfigFactory());
        if (mapperConsumer != null) {
            mapperConsumer.accept(mapper);
        }
        return mapper.build();
    }
}