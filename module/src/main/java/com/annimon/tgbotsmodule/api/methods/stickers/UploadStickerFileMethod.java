package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.StickerFormatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public class UploadStickerFileMethod implements
        UserMethod<UploadStickerFileMethod, File>,
        InputFileMethod<UploadStickerFileMethod, File>,
        StickerFormatMethod<UploadStickerFileMethod, File> {

    private final UploadStickerFile.UploadStickerFileBuilder method;

    public UploadStickerFileMethod() {
        this(UploadStickerFile.builder());

    }

    public UploadStickerFileMethod(@NotNull UploadStickerFile.UploadStickerFileBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public UploadStickerFileMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public String getFormat() {
        return method.build().getStickerFormat();
    }

    @Override
    public UploadStickerFileMethod setFormat(@NotNull String format) {
        method.stickerFormat(format);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getSticker();
    }

    @Override
    public UploadStickerFileMethod setFile(@NotNull InputFile file) {
        method.sticker(file);
        return this;
    }

    @Override
    public File call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<File> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
