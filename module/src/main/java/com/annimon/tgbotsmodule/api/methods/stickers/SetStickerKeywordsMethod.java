package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerKeywords;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetStickerKeywordsMethod implements Method<Boolean> {

    private final SetStickerKeywords method;

    public SetStickerKeywordsMethod() {
        this(new SetStickerKeywords());
    }

    public SetStickerKeywordsMethod(@NotNull SetStickerKeywords method) {
        this.method = method;
    }

    public String getSticker() {
        return method.getSticker();
    }

    public SetStickerKeywordsMethod setSticker(@NotNull String sticker) {
        method.setSticker(sticker);
        return this;
    }

    public List<String> getKeywords() {
        return method.getKeywords();
    }

    public SetStickerKeywordsMethod setKeyword(@NotNull String keyword) {
        return setKeywords(List.of(keyword));
    }

    public SetStickerKeywordsMethod setKeywords(@NotNull List<String> keywords) {
        method.setKeywords(keywords);
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
