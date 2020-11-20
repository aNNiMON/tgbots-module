package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.InputStream;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AddStickerToSetMethod implements
        UserMethod<AddStickerToSetMethod, Boolean>,
        InputFileMethod<AddStickerToSetMethod, Boolean> {

    private final AddStickerToSet method;

    public AddStickerToSetMethod() {
        this(new AddStickerToSet());
    }

    public AddStickerToSetMethod(@NotNull AddStickerToSet method) {
        this.method = method;
    }

    @Override
    public Integer getUserId() {
        return method.getUserId();
    }

    @Override
    public AddStickerToSetMethod setUserId(@NotNull Integer userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getPngSticker();
    }

    @Override
    public AddStickerToSetMethod setFile(@NotNull InputFile file) {
        method.setPngSticker(file);
        return this;
    }

    public String getName() {
        return method.getName();
    }

    public AddStickerToSetMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    public String getEmojis() {
        return method.getEmojis();
    }

    public AddStickerToSetMethod setEmojis(@NotNull String emojis) {
        method.setEmojis(emojis);
        return this;
    }

    public MaskPosition getMaskPosition() {
        return method.getMaskPosition();
    }

    public AddStickerToSetMethod setMaskPosition(MaskPosition maskPosition) {
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
        sender.callAsync(method, responseConsumer, apiExceptionConsumer);
    }
}
