package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerMaskPosition;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetStickerMaskPositionMethod implements Method<Boolean> {

    private final SetStickerMaskPosition method;

    public SetStickerMaskPositionMethod() {
        this(new SetStickerMaskPosition());
    }

    public SetStickerMaskPositionMethod(@NotNull SetStickerMaskPosition method) {
        this.method = method;
    }

    public String getSticker() {
        return method.getSticker();
    }

    public SetStickerMaskPositionMethod setSticker(@NotNull String sticker) {
        method.setSticker(sticker);
        return this;
    }

    public MaskPosition getMaskPosition() {
        return method.getMaskPosition();
    }

    public SetStickerMaskPositionMethod setMaskPosition(@NotNull MaskPosition maskPosition) {
        method.setMaskPosition(maskPosition);
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
