package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CreateNewWebmStickerSetMethod implements
        UserMethod<CreateNewWebmStickerSetMethod, Boolean>,
        InputFileMethod<CreateNewWebmStickerSetMethod, Boolean> {

    private final CreateNewStickerSet method;

    public CreateNewWebmStickerSetMethod() {
        this(new CreateNewStickerSet());
    }

    public CreateNewWebmStickerSetMethod(@NotNull CreateNewStickerSet method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public CreateNewWebmStickerSetMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getWebmSticker();
    }

    @Override
    public CreateNewWebmStickerSetMethod setFile(@NotNull InputFile file) {
        method.setWebmSticker(file);
        return this;
    }

    public String getName() {
        return method.getName();
    }

    public CreateNewWebmStickerSetMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public CreateNewWebmStickerSetMethod setTitle(@NotNull String title) {
        method.setTitle(title);
        return this;
    }

    public String getEmojis() {
        return method.getEmojis();
    }

    public CreateNewWebmStickerSetMethod setEmojis(@NotNull String emojis) {
        method.setEmojis(emojis);
        return this;
    }

    public Boolean getContainsMasks() {
        return method.getContainsMasks();
    }

    public CreateNewWebmStickerSetMethod setContainsMasks(Boolean containsMasks) {
        method.setContainsMasks(containsMasks);
        return this;
    }

    public MaskPosition getMaskPosition() {
        return method.getMaskPosition();
    }

    public CreateNewWebmStickerSetMethod setMaskPosition(MaskPosition maskPosition) {
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
