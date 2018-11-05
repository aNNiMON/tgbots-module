package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface WebPagePreviewMethod<M extends Method, T extends Serializable> extends Method<T> {

    boolean isWebPagePreviewDisabled();

    default boolean isWebPagePreviewEnabled() {
        return !isWebPagePreviewDisabled();
    }

    M enableWebPagePreview();

    M disableWebPagePreview();

    default M setWebPagePreviewEnabled(boolean status) {
        if (status) {
            return enableWebPagePreview();
        } else {
            return disableWebPagePreview();
        }
    }
}