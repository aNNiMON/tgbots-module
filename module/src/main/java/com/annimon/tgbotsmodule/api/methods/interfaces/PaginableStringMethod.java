package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface PaginableStringMethod<M extends Method, T extends Serializable> extends Method<T> {

    String getOffset();

    M setOffset(String offset);

    Integer getLimit();

    M setLimit(Integer limit);
}