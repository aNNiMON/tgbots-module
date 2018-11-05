package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface SendableMessageMethod<M extends Method, T extends Serializable>
        extends ChatMethod<M, T>, NotificationMethod<M, T> {

    Integer getReplyToMessageId();

    M setReplyToMessageId(Integer replyToMessageId);
}