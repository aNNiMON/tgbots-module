package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface RemoveCaptionMethod<M extends Method, T extends Serializable> extends Method<T> {

    Boolean getRemoveCaption();

    M setRemoveCaption(Boolean removeCaption);

    default M removeCaption() {
        return setRemoveCaption(true);
    }
}