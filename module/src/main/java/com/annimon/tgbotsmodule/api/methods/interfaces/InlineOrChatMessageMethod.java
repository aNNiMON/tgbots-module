package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface InlineOrChatMessageMethod<M extends Method, T extends Serializable>
        extends ChatMessageMethod<M, T> {

    String getInlineMessageId();

    M setInlineMessageId(String inlineMessageId);
}
