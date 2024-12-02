package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerEmojiList;

public class SetStickerEmojiListMethod implements Method<Boolean> {

    private final SetStickerEmojiList.SetStickerEmojiListBuilder<?, ?> method;

    public SetStickerEmojiListMethod() {
        this(SetStickerEmojiList.builder());
    }

    public SetStickerEmojiListMethod(@NotNull SetStickerEmojiList.SetStickerEmojiListBuilder<?, ?> method) {
        this.method = method;
    }

    public List<String> getEmojiList() {
        return method.build().getEmojiList();
    }

    public SetStickerEmojiListMethod setEmoji(@NotNull String emoji) {
        return setEmojiList(List.of(emoji));
    }

    public SetStickerEmojiListMethod setEmojiList(@NotNull List<String> emojiList) {
        method.emojiList(emojiList);
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
