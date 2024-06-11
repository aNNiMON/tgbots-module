package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.SetCustomEmojiStickerSetThumbnail;

public class SetCustomEmojiStickerSetThumbnailMethod implements Method<Boolean> {

    private final SetCustomEmojiStickerSetThumbnail.SetCustomEmojiStickerSetThumbnailBuilder method;

    public SetCustomEmojiStickerSetThumbnailMethod() {
        this(SetCustomEmojiStickerSetThumbnail.builder());
    }

    public SetCustomEmojiStickerSetThumbnailMethod(@NotNull SetCustomEmojiStickerSetThumbnail.SetCustomEmojiStickerSetThumbnailBuilder method) {
        this.method = method;
    }

    public String getName() {
        return method.build().getName();
    }

    public SetCustomEmojiStickerSetThumbnailMethod setName(@NotNull String name) {
        method.name(name);
        return this;
    }

    public String getCustomEmojiId() {
        return method.build().getCustomEmojiId();
    }

    public SetCustomEmojiStickerSetThumbnailMethod setCustomEmojiId(@NotNull String customEmojiId) {
        method.customEmojiId(customEmojiId);
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
