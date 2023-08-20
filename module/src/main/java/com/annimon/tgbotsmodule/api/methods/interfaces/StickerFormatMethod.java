package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public interface StickerFormatMethod<M extends Method, T extends Serializable> extends Method<T> {

    String getStickerFormat();

    M setStickerFormat(@NotNull String stickerFormat);

    default boolean isStaticFormat() {
        return Format.STATIC.equals(getStickerFormat());
    }

    default M setStaticFormat() {
        return setStickerFormat(Format.STATIC);
    }

    default boolean isAnimatedFormat() {
        return Format.ANIMATED.equals(getStickerFormat());
    }

    default M setAnimatedFormat() {
        return setStickerFormat(Format.ANIMATED);
    }

    default boolean isVideoFormat() {
        return Format.VIDEO.equals(getStickerFormat());
    }

    default M setVideoFormat() {
        return setStickerFormat(Format.VIDEO);
    }
    
    class Format {
        static final String STATIC = "static";
        static final String ANIMATED = "animated";
        static final String VIDEO = "video";
    }
}