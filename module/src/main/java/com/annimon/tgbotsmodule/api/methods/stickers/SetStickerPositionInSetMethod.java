package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerPositionInSet;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetStickerPositionInSetMethod implements Method<Boolean> {

    private final SetStickerPositionInSet method;

    public SetStickerPositionInSetMethod() {
        this(new SetStickerPositionInSet() {
            @Override
            public String getMethod() {
                return "setStickerPositionInSet";
            }
        });
    }

    public SetStickerPositionInSetMethod(@NotNull SetStickerPositionInSet method) {
        this.method = method;
    }

    public String getSticker() {
        return method.getSticker();
    }

    public SetStickerPositionInSetMethod setSticker(@NotNull String sticker) {
        method.setSticker(sticker);
        return this;
    }

    public Integer getPosition() {
        return method.getPosition();
    }

    public SetStickerPositionInSetMethod setPosition(@NotNull Integer position) {
        method.setPosition(position);
        return this;
    }

    @Override
    public Boolean execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Boolean> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
