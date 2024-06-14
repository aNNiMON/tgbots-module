package com.annimon.tgbotsmodule;

import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.longpolling.util.DefaultGetUpdatesGenerator;
import org.telegram.telegrambots.meta.TelegramUrl;
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public final class BotModuleOptions {

    public static BotModuleOptions createDefault(@NotNull String botToken) {
        return create(botToken)
                .telegramUrlSupplierDefault()
                .getUpdatesGeneratorDefault()
                .build();
    }

    public static Builder create(@NotNull String botToken) {
        return new Builder(botToken);
    }

    private final String botToken;
    private final Supplier<TelegramUrl> telegramUrlSupplier;
    private final Function<Integer, GetUpdates> getUpdatesGenerator;

    private BotModuleOptions(String botToken,
                             Supplier<TelegramUrl> telegramUrlSupplier,
                             Function<Integer, GetUpdates> getUpdatesGenerator) {
        this.botToken = botToken;
        this.telegramUrlSupplier = telegramUrlSupplier;
        this.getUpdatesGenerator = getUpdatesGenerator;
    }

    String botToken() {
        return botToken;
    }

    Supplier<TelegramUrl> telegramUrlSupplier() {
        return telegramUrlSupplier;
    }

    Function<Integer, GetUpdates> getUpdatesGenerator() {
        return getUpdatesGenerator;
    }

    public static class Builder {
        private final String botToken;
        private Supplier<TelegramUrl> telegramUrlSupplier;
        private Function<Integer, GetUpdates> getUpdatesGenerator;

        private Builder(String botToken) {
            this.botToken = botToken;
        }

        public Builder telegramUrlSupplier(Supplier<TelegramUrl> supplier) {
            telegramUrlSupplier = supplier;
            return this;
        }

        public Builder telegramUrlSupplierDefault() {
            telegramUrlSupplier = () -> TelegramUrl.DEFAULT_URL;
            return this;
        }

        public Builder getUpdatesGenerator(Function<Integer, GetUpdates> generator) {
            getUpdatesGenerator = generator;
            return this;
        }

        public Builder getUpdatesGeneratorDefaultWithAllowedUpdates(List<String> allowedUpdates) {
            getUpdatesGenerator = new DefaultGetUpdatesGenerator(allowedUpdates);
            return this;
        }

        public Builder getUpdatesGeneratorDefault() {
            getUpdatesGenerator = new DefaultGetUpdatesGenerator();
            return this;
        }

        public BotModuleOptions build() {
            if (telegramUrlSupplier == null) telegramUrlSupplierDefault();
            if (getUpdatesGenerator == null) getUpdatesGeneratorDefault();
            return new BotModuleOptions(botToken, telegramUrlSupplier, getUpdatesGenerator);
        }
    }
}
