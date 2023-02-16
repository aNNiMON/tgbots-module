package com.annimon.tgbotsmodule.analytics;

import com.annimon.tgbotsmodule.BotHandler;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateHandler {

    /**
     * Handles new Update
     *
     * @param update  bot update
     * @return {@code true} if update was handled, {@code false} otherwise
     */
    boolean handleUpdate(@NotNull Update update, BotHandler handler);
}
