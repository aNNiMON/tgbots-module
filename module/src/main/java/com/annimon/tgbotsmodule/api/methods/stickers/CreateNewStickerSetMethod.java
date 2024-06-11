package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.objects.stickers.InputSticker;

public class CreateNewStickerSetMethod implements
        UserMethod<CreateNewStickerSetMethod, Boolean> {

    private static final String REGULAR_TYPE = "regular";
    private static final String MASK_TYPE = "mask";
    private static final String CUSTOM_EMOJI_TYPE = "custom_emoji";
    private final CreateNewStickerSet.CreateNewStickerSetBuilder method;

    public CreateNewStickerSetMethod() {
        this(CreateNewStickerSet.builder());
    }

    public CreateNewStickerSetMethod(@NotNull CreateNewStickerSet.CreateNewStickerSetBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public CreateNewStickerSetMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public List<InputSticker> getStickers() {
        return method.build().getStickers();
    }

    public CreateNewStickerSetMethod setStickers(@NotNull List<InputSticker> stickers) {
        method.stickers(stickers);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public CreateNewStickerSetMethod setName(@NotNull String name) {
        method.name(name);
        return this;
    }

    public String getTitle() {
        return method.build().getTitle();
    }

    public CreateNewStickerSetMethod setTitle(@NotNull String title) {
        method.title(title);
        return this;
    }

    public String getStickerType() {
        return method.build().getStickerType();
    }

    public CreateNewStickerSetMethod setStickerType(String stickerType) {
        method.stickerType(stickerType);
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
        return Boolean.TRUE.equals(method.build().getNeedsRepainting());
    }

    public CreateNewStickerSetMethod setNeedsRepainting(boolean needsRepainting) {
        method.needsRepainting(needsRepainting);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
