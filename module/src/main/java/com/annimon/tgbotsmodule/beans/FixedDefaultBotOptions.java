package com.annimon.tgbotsmodule.beans;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiConstants;

/**
 * There's a bug in Ruben's org.telegram.telegrambots.bots.DefaultBotOptions.
 * getUpdatesTimeout should be 50, but since there's no assignment to that field in the constructor,
 * it defaults to 0, but 0 should be used for testing purpose only
 * So that class fixes this and sets getUpdatesTimeout to 50
 */
public class FixedDefaultBotOptions extends DefaultBotOptions {

    public FixedDefaultBotOptions() {
        super();
        setGetUpdatesTimeout(ApiConstants.GETUPDATES_TIMEOUT);
    }

}