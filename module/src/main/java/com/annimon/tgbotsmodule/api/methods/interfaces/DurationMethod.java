package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface DurationMethod<M extends Method, T extends Serializable> extends Method<T> {

    Integer getDuration();

    M setDuration(Integer duration);
}