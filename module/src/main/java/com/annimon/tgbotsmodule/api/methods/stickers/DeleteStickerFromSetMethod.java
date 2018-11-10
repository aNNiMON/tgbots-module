package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.DeleteStickerFromSet;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeleteStickerFromSetMethod implements Method<Boolean> {

    private final DeleteStickerFromSet method;

    public DeleteStickerFromSetMethod() {
        this(new DeleteStickerFromSet());
    }

    public DeleteStickerFromSetMethod(@NotNull DeleteStickerFromSet method) {
        this.method = method;
    }

    public String getSticker() {
        return method.getSticker();
    }

    public DeleteStickerFromSetMethod setSticker(@NotNull String sticker) {
        method.setSticker(sticker);
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
