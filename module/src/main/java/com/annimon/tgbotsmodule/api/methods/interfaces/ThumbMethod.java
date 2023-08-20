package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public interface ThumbMethod<M extends Method, T extends Serializable> extends Method<T> {

    InputFile getThumbnail();

    M setThumbnail(InputFile thumb);


    /**
     * @deprecated Use {@link #getThumbnail()}
     */
    @Deprecated
    default InputFile getThumb() {
        return getThumbnail();
    }

    /**
     * @deprecated Use {@link #setThumbnail(InputFile)}
     */
    @Deprecated
    default M setThumb(InputFile thumb) {
        return setThumbnail(thumb);
    }
}