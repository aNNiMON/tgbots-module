package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerMaskPosition;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;

public class SetStickerMaskPositionMethod implements Method<Boolean> {

    private final SetStickerMaskPosition.SetStickerMaskPositionBuilder method;

    public SetStickerMaskPositionMethod() {
        this(SetStickerMaskPosition.builder());
    }

    public SetStickerMaskPositionMethod(@NotNull SetStickerMaskPosition.SetStickerMaskPositionBuilder method) {
        this.method = method;
    }

    public String getSticker() {
        return method.build().getSticker();
    }

    public SetStickerMaskPositionMethod setSticker(@NotNull String sticker) {
        method.sticker(sticker);
        return this;
    }

    public MaskPosition getMaskPosition() {
        return method.build().getMaskPosition();
    }

    public SetStickerMaskPositionMethod setMaskPosition(@NotNull MaskPosition maskPosition) {
        method.maskPosition(maskPosition);
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
