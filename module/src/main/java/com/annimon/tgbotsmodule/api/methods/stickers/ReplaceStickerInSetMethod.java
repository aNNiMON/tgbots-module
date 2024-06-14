package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.ReplaceStickerInSet;
import org.telegram.telegrambots.meta.api.objects.stickers.InputSticker;

public class ReplaceStickerInSetMethod implements
        UserMethod<ReplaceStickerInSetMethod, Boolean> {

    private final ReplaceStickerInSet.ReplaceStickerInSetBuilder method;

    public ReplaceStickerInSetMethod() {
        this(ReplaceStickerInSet.builder());
    }

    public ReplaceStickerInSetMethod(@NotNull ReplaceStickerInSet.ReplaceStickerInSetBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public ReplaceStickerInSetMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public String getOldSticker() {
        return method.build().getOldSticker();
    }

    public ReplaceStickerInSetMethod setOldSticker(@NotNull String oldSticker) {
        method.oldSticker(oldSticker);
        return this;
    }

    public InputSticker getSticker() {
        return method.build().getSticker();
    }

    public ReplaceStickerInSetMethod setSticker(@NotNull InputSticker sticker) {
        method.sticker(sticker);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public ReplaceStickerInSetMethod setName(@NotNull String name) {
        method.name(name);
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
