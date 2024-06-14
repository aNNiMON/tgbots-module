package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface BusinessConnectionMethod<M extends Method, T extends Serializable> extends
        Method<T> {

    String getBusinessConnectionId();

    M setBusinessConnectionId(String id);
}
