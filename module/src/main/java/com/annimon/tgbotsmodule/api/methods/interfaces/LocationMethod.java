package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface LocationMethod<M extends Method, T extends Serializable> extends Method<T> {

    Float getLatitude();

    M setLatitude(Float latitude);

    Float getLongitude();

    M setLongitude(Float longitude);
}