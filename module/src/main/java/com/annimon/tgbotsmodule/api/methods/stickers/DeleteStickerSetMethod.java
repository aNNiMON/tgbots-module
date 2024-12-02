package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.DeleteStickerSet;

public class DeleteStickerSetMethod implements Method<Boolean> {

    private final DeleteStickerSet.DeleteStickerSetBuilder<?, ?> method;

    public DeleteStickerSetMethod() {
        this(DeleteStickerSet.builder());
    }

    public DeleteStickerSetMethod(@NotNull DeleteStickerSet.DeleteStickerSetBuilder<?, ?> method) {
        this.method = method;
    }

    public String getName() {
        return method.build().getName();
    }

    public DeleteStickerSetMethod setName(@NotNull String name) {
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
