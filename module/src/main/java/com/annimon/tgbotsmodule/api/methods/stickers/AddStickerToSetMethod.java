package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.objects.stickers.InputSticker;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AddStickerToSetMethod implements
        UserMethod<AddStickerToSetMethod, Boolean> {

    private final AddStickerToSet method;

    public AddStickerToSetMethod() {
        this(new AddStickerToSet());
    }

    public AddStickerToSetMethod(@NotNull AddStickerToSet method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public AddStickerToSetMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    public InputSticker getSticker() {
        return method.getSticker();
    }

    public AddStickerToSetMethod setSticker(@NotNull InputSticker sticker) {
        method.setSticker(sticker);
        return this;
    }

    public String getName() {
        return method.getName();
    }

    public AddStickerToSetMethod setName(@NotNull String name) {
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
        sender.callAsync(method, responseConsumer, apiExceptionConsumer);
    }
}
