package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface PaginableMethod<M extends Method, T extends Serializable> extends Method<T> {

    Integer getOffset();

    M setOffset(Integer offset);

    Integer getLimit();

    M setLimit(Integer limit);
}