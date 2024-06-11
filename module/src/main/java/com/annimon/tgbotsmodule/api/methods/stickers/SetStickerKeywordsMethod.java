package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerKeywords;

public class SetStickerKeywordsMethod implements Method<Boolean> {

    private final SetStickerKeywords.SetStickerKeywordsBuilder method;

    public SetStickerKeywordsMethod() {
        this(SetStickerKeywords.builder());
    }

    public SetStickerKeywordsMethod(@NotNull SetStickerKeywords.SetStickerKeywordsBuilder method) {
        this.method = method;
    }

    public String getSticker() {
        return method.build().getSticker();
    }

    public SetStickerKeywordsMethod setSticker(@NotNull String sticker) {
        method.sticker(sticker);
        return this;
    }

    public List<String> getKeywords() {
        return method.build().getKeywords();
    }

    public SetStickerKeywordsMethod setKeyword(@NotNull String keyword) {
        return setKeywords(List.of(keyword));
    }

    public SetStickerKeywordsMethod setKeywords(@NotNull List<String> keywords) {
        method.keywords(keywords);
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
