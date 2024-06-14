package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.StickerFormatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetThumbnail;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public class SetStickerSetThumbnailMethod implements
        UserMethod<SetStickerSetThumbnailMethod, Boolean>,
        InputFileMethod<SetStickerSetThumbnailMethod, Boolean>,
        StickerFormatMethod<SetStickerSetThumbnailMethod, Boolean> {

    private final SetStickerSetThumbnail.SetStickerSetThumbnailBuilder method;

    public SetStickerSetThumbnailMethod() {
        this(SetStickerSetThumbnail.builder());
    }

    public SetStickerSetThumbnailMethod(@NotNull SetStickerSetThumbnail.SetStickerSetThumbnailBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public SetStickerSetThumbnailMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public String getFormat() {
        return method.build().getFormat();
    }

    @Override
    public SetStickerSetThumbnailMethod setFormat(@NotNull String format) {
        method.format(format);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getThumbnail();
    }

    @Override
    public SetStickerSetThumbnailMethod setFile(@NotNull InputFile file) {
        method.thumbnail(file);
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
