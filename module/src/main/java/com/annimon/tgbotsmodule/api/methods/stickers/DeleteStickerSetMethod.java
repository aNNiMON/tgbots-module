package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.DeleteStickerSet;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeleteStickerSetMethod implements Method<Boolean> {

    private final DeleteStickerSet method;

    public DeleteStickerSetMethod() {
        this(new DeleteStickerSet());
    }

    public DeleteStickerSetMethod(@NotNull DeleteStickerSet method) {
        this.method = method;
    }

    public String getName() {
        return method.getName();
    }

    public DeleteStickerSetMethod setName(@NotNull String name) {
        method.setName(name);
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
