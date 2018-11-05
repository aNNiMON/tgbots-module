package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.telegram.telegrambots.meta.api.methods.ParseMode;

public interface ParseModeMethod<M extends Method, T extends Serializable> extends Method<T> {

    String getParseMode();

    M setParseMode(String parseMode);

    default M enableMarkdown() {
        return enableMarkdown(true);
    }

    default M enableMarkdown(boolean enable) {
        return setParseMode(enable ? ParseMode.MARKDOWN : null);
    }

    default M enableHtml() {
        return enableHtml(true);
    }

    default M enableHtml(boolean enable) {
        return setParseMode(enable ? ParseMode.HTML : null);
    }
}