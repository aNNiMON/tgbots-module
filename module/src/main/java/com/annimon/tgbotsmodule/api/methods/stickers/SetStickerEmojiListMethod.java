package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerEmojiList;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetStickerEmojiListMethod implements Method<Boolean> {

    private final SetStickerEmojiList method;

    public SetStickerEmojiListMethod() {
        this(new SetStickerEmojiList());
    }

    public SetStickerEmojiListMethod(@NotNull SetStickerEmojiList method) {
        this.method = method;
    }

    public List<String> getEmojiList() {
        return method.getEmojiList();
    }

    public SetStickerEmojiListMethod setEmoji(@NotNull String emoji) {
        return setEmojiList(List.of(emoji));
    }

    public SetStickerEmojiListMethod setEmojiList(@NotNull List<String> emojiList) {
        method.setEmojiList(emojiList);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Boolean> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
