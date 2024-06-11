package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerPositionInSet;

public class SetStickerPositionInSetMethod implements Method<Boolean> {

    private final SetStickerPositionInSet.SetStickerPositionInSetBuilder method;

    public SetStickerPositionInSetMethod() {
        this(SetStickerPositionInSet.builder());
    }

    public SetStickerPositionInSetMethod(@NotNull SetStickerPositionInSet.SetStickerPositionInSetBuilder method) {
        this.method = method;
    }

    public String getSticker() {
        return method.build().getSticker();
    }

    public SetStickerPositionInSetMethod setSticker(@NotNull String sticker) {
        method.sticker(sticker);
        return this;
    }

    public Integer getPosition() {
        return method.build().getPosition();
    }

    public SetStickerPositionInSetMethod setPosition(@NotNull Integer position) {
        method.position(position);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
