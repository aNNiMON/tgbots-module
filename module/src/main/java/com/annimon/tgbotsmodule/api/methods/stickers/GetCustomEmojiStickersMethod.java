package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.GetCustomEmojiStickers;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;

public class GetCustomEmojiStickersMethod implements Method<ArrayList<Sticker>> {

    private final GetCustomEmojiStickers.GetCustomEmojiStickersBuilder method;

    public GetCustomEmojiStickersMethod() {
        this(GetCustomEmojiStickers.builder());
    }

    public GetCustomEmojiStickersMethod(@NotNull GetCustomEmojiStickers.GetCustomEmojiStickersBuilder method) {
        this.method = method;
    }

    public List<String> getCustomEmojiIds() {
        return method.build().getCustomEmojiIds();
    }

    public GetCustomEmojiStickersMethod setCustomEmojiIds(@NotNull List<String> emojiIds) {
        method.customEmojiIds(emojiIds);
        return this;
    }

    public GetCustomEmojiStickersMethod setCustomEmojiIds(@NotNull String... emojiIds) {
        method.customEmojiIds(List.of(emojiIds));
        return this;
    }

    @Override
    public ArrayList<Sticker> call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ArrayList<Sticker>> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
