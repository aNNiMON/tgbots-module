package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.objects.stickers.InputSticker;

public class AddStickerToSetMethod implements
        UserMethod<AddStickerToSetMethod, Boolean> {

    private final AddStickerToSet.AddStickerToSetBuilder method;

    public AddStickerToSetMethod() {
        this(AddStickerToSet.builder());
    }

    public AddStickerToSetMethod(@NotNull AddStickerToSet.AddStickerToSetBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public AddStickerToSetMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public InputSticker getSticker() {
        return method.build().getSticker();
    }

    public AddStickerToSetMethod setSticker(@NotNull InputSticker sticker) {
        method.sticker(sticker);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public AddStickerToSetMethod setName(@NotNull String name) {
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
