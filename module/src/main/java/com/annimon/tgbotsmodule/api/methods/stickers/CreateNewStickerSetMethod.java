package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.InputStream;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CreateNewStickerSetMethod implements
        UserMethod<CreateNewStickerSetMethod, Boolean>,
        InputFileMethod<CreateNewStickerSetMethod, Boolean> {

    private final CreateNewStickerSet method;

    public CreateNewStickerSetMethod() {
        this(new CreateNewStickerSet());
    }

    public CreateNewStickerSetMethod(@NotNull CreateNewStickerSet method) {
        this.method = method;
    }

    @Override
    public Integer getUserId() {
        return method.getUserId();
    }

    @Override
    public CreateNewStickerSetMethod setUserId(@NotNull Integer userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getPngSticker();
    }

    @Override
    public CreateNewStickerSetMethod setFile(@NotNull InputFile file) {
        method.setPngSticker(file);
        return this;
    }

    public String getName() {
        return method.getName();
    }

    public CreateNewStickerSetMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public CreateNewStickerSetMethod setTitle(@NotNull String title) {
        method.setTitle(title);
        return this;
    }

    public String getEmojis() {
        return method.getEmojis();
    }

    public CreateNewStickerSetMethod setEmojis(@NotNull String emojis) {
        method.setEmojis(emojis);
        return this;
    }

    public Boolean getContainsMasks() {
        return method.getContainsMasks();
    }

    public CreateNewStickerSetMethod setContainsMasks(Boolean containsMasks) {
        method.setContainsMasks(containsMasks);
        return this;
    }

    public MaskPosition getMaskPosition() {
        return method.getMaskPosition();
    }

    public CreateNewStickerSetMethod setMaskPosition(MaskPosition maskPosition) {
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
