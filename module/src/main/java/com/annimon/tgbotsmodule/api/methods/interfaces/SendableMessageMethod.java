package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface SendableMessageMethod<M extends Method, T extends Serializable>
        extends ChatMethod<M, T>, NotificationMethod<M, T> {

    Integer getReplyToMessageId();

    M setReplyToMessageId(Integer replyToMessageId);

    default M inReplyTo(Message message) {
        return setReplyToMessageId(message.getMessageId());
    }

    Boolean getAllowSendingWithoutReply();

    M setAllowSendingWithoutReply(Boolean allowSendingWithoutReply);
}
