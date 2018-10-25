package com.annimon.tgbotsmodule.analytics;

import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateRegister {

    /**
     * Registers new Update
     *
     * @param update  bot update
     * @return {@code true} if update was register, {@code false} otherwise
     */
    boolean registerUpdate(@NotNull Update update);
}
