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

public class CreateNewStickerSetMethod implements
        UserMethod<CreateNewStickerSetMethod, Boolean>,
        InputFileMethod<CreateNewStickerSetMethod, Boolean> {

    private static final String REGULAR_TYPE = "regular";
    private static final String MASK_TYPE = "mask";
    private final CreateNewStickerSet method;

    public CreateNewStickerSetMethod() {
        this(new CreateNewStickerSet());
    }

    public CreateNewStickerSetMethod(@NotNull CreateNewStickerSet method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public CreateNewStickerSetMethod setUserId(@NotNull Long userId) {
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

    public String getStickerType() {
        return method.getStickerType();
    }

    public CreateNewStickerSetMethod setStickerType(String stickerType) {
        method.setStickerType(stickerType);
        return this;
    }

    public boolean isRegularSticker() {
        return REGULAR_TYPE.equals(getStickerType());
    }

    public CreateNewStickerSetMethod setRegularType() {
        return setStickerType(REGULAR_TYPE);
    }

    public boolean isMask() {
        return MASK_TYPE.equals(getStickerType());
    }

    public CreateNewStickerSetMethod setMaskType() {
        return setStickerType(MASK_TYPE);
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
