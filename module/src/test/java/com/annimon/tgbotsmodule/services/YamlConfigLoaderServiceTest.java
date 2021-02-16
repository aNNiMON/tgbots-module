package com.annimon.tgbotsmodule.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.stream.Stream;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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

        final var converter = new YamlConfigLoaderService<EnvConfig>();
        final var config = converter.load(converter.configFile("src/test/resources/env", name), EnvConfig.class);

        assertThat(config.actual, is(not(nullValue())));
        assertThat(config.expected, is(not(nullValue())));
        assertThat(config.actual.entrySet(), everyItem(isIn(config.expected.entrySet())));
        assertThat(config.expected.entrySet(), everyItem(isIn(config.actual.entrySet())));
    }

    static class EnvConfig {
        @JsonProperty(required = true)
        Map<String, Object> actual;

        @JsonProperty(required = true)
        Map<String, Object> expected;
    }
}
