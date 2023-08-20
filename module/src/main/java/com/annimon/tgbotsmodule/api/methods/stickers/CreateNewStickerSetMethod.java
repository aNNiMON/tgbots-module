package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.StickerFormatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.objects.stickers.InputSticker;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CreateNewStickerSetMethod implements
        UserMethod<CreateNewStickerSetMethod, Boolean>,
        StickerFormatMethod<CreateNewStickerSetMethod, Boolean> {


    private static final String REGULAR_TYPE = "regular";
    private static final String MASK_TYPE = "mask";
    private static final String CUSTOM_EMOJI_TYPE = "custom_emoji";
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

    public List<InputSticker> getStickers() {
        return method.getStickers();
    }

    public CreateNewStickerSetMethod setStickers(@NotNull List<InputSticker> stickers) {
        method.setStickers(stickers);
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

    @Override
    public String getStickerFormat() {
        return method.getStickerFormat();
    }

    @Override
    public CreateNewStickerSetMethod setStickerFormat(@NotNull String stickerFormat) {
        method.setStickerFormat(stickerFormat);
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

    public boolean isCustomEmoji() {
        return CUSTOM_EMOJI_TYPE.equals(getStickerType());
    }

    public CreateNewStickerSetMethod setCustomEmojiType() {
        return setStickerType(CUSTOM_EMOJI_TYPE);
    }

    public boolean getNeedsRepainting() {
        return Boolean.TRUE.equals(method.getNeedsRepainting());
    }

    public CreateNewStickerSetMethod setNeedsRepainting(boolean needsRepainting) {
        method.setNeedsRepainting(needsRepainting);
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
