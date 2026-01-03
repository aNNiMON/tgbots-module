package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface DirectMessageTopicMethod<M extends Method, T extends Serializable>
        extends ChatMethod<M, T> {

    Integer getDirectMessagesTopicId();

    M setDirectMessagesTopicId(Integer topicId);
}
