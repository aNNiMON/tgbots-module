package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface ChatMessageMethod<M extends Method, T extends Serializable>
        extends ChatMethod<M, T> {

    Integer getMessageId();

    M setMessageId(Integer messageId);
}
