package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface UserMethod<M extends Method, T extends Serializable> extends Method<T> {

    Integer getUserId();

    M setUserId(Integer userId);
}