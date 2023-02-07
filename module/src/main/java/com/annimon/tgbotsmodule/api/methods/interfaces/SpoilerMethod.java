package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface SpoilerMethod<M extends Method, T extends Serializable> extends Method<T> {

    Boolean getHasSpoiler();

    M setHasSpoiler(Boolean spoiler);

    default M enableSpoiler() {
        return setHasSpoiler(true);
    }

    default M disableSpoiler() {
        return setHasSpoiler(false);
    }
}