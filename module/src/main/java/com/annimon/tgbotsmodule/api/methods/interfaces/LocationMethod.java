package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface LocationMethod<M extends Method, T extends Serializable> extends Method<T> {

    Double getLatitude();

    M setLatitude(Double latitude);

    Double getLongitude();

    M setLongitude(Double longitude);
}