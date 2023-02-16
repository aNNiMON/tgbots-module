package com.annimon.tgbotsmodule.analytics;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateHandler {

    /**
     * Handles new Update
     *
     * @param sender  sender context
     * @param update  bot update
     * @return {@code true} if update was handled, {@code false} otherwise
     */
    boolean handleUpdate(@NotNull CommonAbsSender sender, @NotNull Update update);
}
