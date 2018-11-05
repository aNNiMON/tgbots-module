package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface ChatMethod<M extends Method, T extends Serializable> extends Method<T> {

    String getChatId();

    M setChatId(String chatId);

    default M setChatId(long chatId) {
        return setChatId(Long.toString(chatId, 10));
    }
}