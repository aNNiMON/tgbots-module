package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface ChatMessageThreadMethod<M extends Method, T extends Serializable>
        extends ChatMethod<M, T> {

    Integer getMessageThreadId();

    M setMessageThreadId(Integer messageThreadId);
}
