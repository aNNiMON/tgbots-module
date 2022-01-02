package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface ProtectedContentMethod<M extends Method, T extends Serializable> extends Method<T> {

    Boolean getProtectContent();

    M setProtectContent(Boolean protectContent);

    default M protectContent() {
        return setProtectContent(true);
    }
}