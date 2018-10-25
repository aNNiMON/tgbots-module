package com.annimon.tgbotsmodule.analytics;

import org.jetbrains.annotations.Nullable;

public interface EventRegister {

    /**
     * Register received event
     *
     * @param event  an event from user
     */
    void received(@Nullable Event event);

    /**
     * Register sent event
     *
     * @param event  an event from bot
     */
    void sent(@Nullable Event event);
}
