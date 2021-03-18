package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.beans.Config;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

public interface BotModule {

    @NotNull
    BotHandler botHandler(@NotNull Config config);

    default void configureWebHook(@NotNull SetWebhook.SetWebhookBuilder webhookBuilder) {
    }
}