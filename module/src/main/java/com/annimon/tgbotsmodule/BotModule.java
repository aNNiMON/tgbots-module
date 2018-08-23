package com.annimon.tgbotsmodule;

import com.annimon.tgbotsmodule.beans.Config;

public interface BotModule {

    BotHandler botHandler(Config config);
}