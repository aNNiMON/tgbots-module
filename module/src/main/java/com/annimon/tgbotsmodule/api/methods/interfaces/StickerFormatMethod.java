package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public interface StickerFormatMethod<M extends Method, T extends Serializable> extends Method<T> {

    String getFormat();

    M setFormat(@NotNull String format);

    default boolean isStaticFormat() {
        return Format.STATIC.equals(getFormat());
    }

    default M setStaticFormat() {
        return setFormat(Format.STATIC);
    }

    default boolean isAnimatedFormat() {
        return Format.ANIMATED.equals(getFormat());
    }

    default M setAnimatedFormat() {
        return setFormat(Format.ANIMATED);
    }

    default boolean isVideoFormat() {
        return Format.VIDEO.equals(getFormat());
    }

    default M setVideoFormat() {
        return setFormat(Format.VIDEO);
    }
    
    class Format {
        private Format() {}
        static final String STATIC = "static";
        static final String ANIMATED = "animated";
        static final String VIDEO = "video";
    }
}