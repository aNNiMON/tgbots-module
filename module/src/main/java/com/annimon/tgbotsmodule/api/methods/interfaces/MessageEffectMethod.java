package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface MessageEffectMethod<M extends Method, T extends Serializable> extends
        Method<T> {

    String getMessageEffectId();

    M setMessageEffectId(String messageEffectId);
}
