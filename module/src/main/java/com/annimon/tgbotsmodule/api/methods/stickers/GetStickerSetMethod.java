package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.GetStickerSet;
import org.telegram.telegrambots.meta.api.objects.stickers.StickerSet;

public class GetStickerSetMethod implements Method<StickerSet> {

    private final GetStickerSet.GetStickerSetBuilder method;

    public GetStickerSetMethod() {
        this(GetStickerSet.builder());
    }

    public GetStickerSetMethod(@NotNull GetStickerSet.GetStickerSetBuilder method) {
        this.method = method;
    }

    public String getName() {
        return method.build().getName();
    }

    public GetStickerSetMethod setName(@NotNull String name) {
        method.name(name);
        return this;
    }

    @Override
    public StickerSet call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<StickerSet> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
