package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.beans.Config;
import org.jetbrains.annotations.NotNull;

public interface BotModule {

    @NotNull
    BotHandler botHandler(@NotNull Config config);
}