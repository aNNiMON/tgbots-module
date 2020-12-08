package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

public interface ParseModeMethod<M extends Method, T extends Serializable> extends Method<T> {

    String getParseMode();

    M setParseMode(String parseMode);

    default M enableMarkdown() {
        return enableMarkdown(true);
    }

    default M enableMarkdown(boolean enable) {
        return setParseMode(enable ? ParseMode.MARKDOWN : null);
    }

    default M enableMarkdownV2() {
        return enableMarkdownV2(true);
    }

    default M enableMarkdownV2(boolean enable) {
        return setParseMode(enable ? ParseMode.MARKDOWNV2 : null);
    }

    default M enableHtml() {
        return enableHtml(true);
    }

    default M enableHtml(boolean enable) {
        return setParseMode(enable ? ParseMode.HTML : null);
    }

    List<MessageEntity> getEntities();

    M setEntities(List<MessageEntity> entities);

    default M setEntity(MessageEntity entities) {
        return setEntities(Collections.singletonList(entities));
    }

    default M clearEntities() {
        return setEntities(Collections.emptyList());
    }
}