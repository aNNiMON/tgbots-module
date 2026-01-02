package com.annimon.tgbotsmodule.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import tools.jackson.core.JsonEncoding;
import tools.jackson.core.io.IOContext;
import tools.jackson.dataformat.yaml.YAMLFactory;

public class YamlConfigFactory extends YAMLFactory {

    private static final Pattern PATTERN_ENV = Pattern.compile("env\\((?<key>\\w+):?(?<default>.*?)?\\)");

    @Override
    protected Reader _createReader(byte[] data, int offset, int len, JsonEncoding enc,
                                   IOContext ctxt) {
        try {
            return wrap(super._createReader(data, offset, len, enc, ctxt));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Reader _createReader(InputStream in, JsonEncoding enc,
                                   IOContext ctxt) {
        try {
            return wrap(super._createReader(in, enc, ctxt));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Reader wrap(Reader reader) throws IOException {
        final var contents = IOUtils.toString(reader);
        final var sb = new StringBuilder();
        final var m = PATTERN_ENV.matcher(contents);
        while (m.find()) {
            final var key = m.group("key");
            var value = System.getProperty(key);
            if (value == null) {
                value = System.getenv(key);
            }
            if (value == null && m.groupCount() == 2) {
                value = m.group("default");
            }
            m.appendReplacement(sb, value);
        }
        m.appendTail(sb);
        return new StringReader(sb.toString());
    }
}
