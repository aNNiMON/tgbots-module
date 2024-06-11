package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public interface ChatMessageThreadMethod<M extends Method, T extends Serializable>
        extends ChatMethod<M, T> {

    Integer getMessageThreadId();

    M setMessageThreadId(Integer messageThreadId);

    default M inThread(Message message) {
        return setMessageThreadId(message.getMessageThreadId());
    }
}
