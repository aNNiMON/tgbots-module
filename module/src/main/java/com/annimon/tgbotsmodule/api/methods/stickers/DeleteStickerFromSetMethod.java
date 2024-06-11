package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.DeleteStickerFromSet;

public class DeleteStickerFromSetMethod implements Method<Boolean> {

    private final DeleteStickerFromSet.DeleteStickerFromSetBuilder method;

    public DeleteStickerFromSetMethod() {
        this(DeleteStickerFromSet.builder());
    }

    public DeleteStickerFromSetMethod(@NotNull DeleteStickerFromSet.DeleteStickerFromSetBuilder method) {
        this.method = method;
    }

    public String getSticker() {
        return method.build().getSticker();
    }

    public DeleteStickerFromSetMethod setSticker(@NotNull String sticker) {
        method.sticker(sticker);
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
