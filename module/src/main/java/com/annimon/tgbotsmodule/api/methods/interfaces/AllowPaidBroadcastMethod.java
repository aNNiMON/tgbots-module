package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface AllowPaidBroadcastMethod<M extends Method, T extends Serializable> extends Method<T> {

    Boolean getAllowPaidBroadcast();

    M setAllowPaidBroadcast(Boolean protectContent);

    default M allowPaidBroadcast() {
        return setAllowPaidBroadcast(true);
    }
}