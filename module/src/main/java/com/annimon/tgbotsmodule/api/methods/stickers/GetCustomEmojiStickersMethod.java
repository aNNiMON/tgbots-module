package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.GetCustomEmojiStickers;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GetCustomEmojiStickersMethod implements Method<ArrayList<Sticker>> {

    private final GetCustomEmojiStickers method;

    public GetCustomEmojiStickersMethod() {
        this(new GetCustomEmojiStickers());
    }

    public GetCustomEmojiStickersMethod(@NotNull GetCustomEmojiStickers method) {
        this.method = method;
    }

    public List<String> getCustomEmojiIds() {
        return method.getCustomEmojiIds();
    }

    public GetCustomEmojiStickersMethod setCustomEmojiIds(@NotNull List<String> emojiIds) {
        method.setCustomEmojiIds(emojiIds);
        return this;
    }

    public GetCustomEmojiStickersMethod setCustomEmojiIds(@NotNull String... emojiIds) {
        method.setCustomEmojiIds(List.of(emojiIds));
        return this;
    }

    @Override
    public ArrayList<Sticker> call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super ArrayList<Sticker>> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
