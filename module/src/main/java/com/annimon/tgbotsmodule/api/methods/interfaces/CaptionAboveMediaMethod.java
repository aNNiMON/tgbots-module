package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface CaptionAboveMediaMethod<M extends Method, T extends Serializable> extends Method<T> {

    Boolean getShowCaptionAboveMedia();

    M setShowCaptionAboveMedia(Boolean showCaptionAboveMedia);

    default M showCaptionAboveMedia() {
        return setShowCaptionAboveMedia(true);
    }
}