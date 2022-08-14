package com.annimon.tgbotsmodule.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class YamlConfigLoaderServiceTest {

    static Stream<Arguments> configNameAndPropsProvider() {
        return Stream.of(
                arguments("simple", Map.of()),
                arguments("replacing",
                        Map.of("KEY1", "first")),
                arguments("multiplereplacing",
                        Map.of("IP", "127.0.0.1",
                                "PORT", "8888"))
        );
    }

    @ParameterizedTest(name = "{index}. {0}")
    @MethodSource("configNameAndPropsProvider")
    void testConverter(String name, Map<String, String> props) {
        props.forEach(System::setProperty);

        final var converter = new YamlConfigLoaderService();
        final var config = converter.loadFile(converter.configFile("src/test/resources/env", name), EnvConfig.class);

        assertThat(config.actual).isNotNull();
        assertThat(config.expected).isNotNull();
        assertThat(config.actual).containsAllEntriesOf(config.expected);
        assertThat(config.expected).containsAllEntriesOf(config.actual);
    }

    static class EnvConfig {
        @JsonProperty(required = true)
        Map<String, Object> actual;

        @JsonProperty(required = true)
        Map<String, Object> expected;
    }
}
