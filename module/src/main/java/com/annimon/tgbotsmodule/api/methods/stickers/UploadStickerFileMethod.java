package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.InputStream;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UploadStickerFileMethod implements
        UserMethod<UploadStickerFileMethod, File>,
        InputFileMethod<UploadStickerFileMethod, File> {

    private final UploadStickerFile method;

    public UploadStickerFileMethod() {
        this(new UploadStickerFile());
    }

    public UploadStickerFileMethod(@NotNull UploadStickerFile method) {
        this.method = method;
    }

    @Override
    public Integer getUserId() {
        return method.getUserId();
    }

    @Override
    public UploadStickerFileMethod setUserId(@NotNull Integer userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getPngSticker();
    }

    @Override
    public UploadStickerFileMethod setFile(String fileId) {
        throw new UnsupportedOperationException("UploadStickerFile doesn't support setting files as fileId");
    }

    @Override
    public UploadStickerFileMethod setFile(@NotNull java.io.File file) {
        method.setPngSticker(file);
        return this;
    }

    @Override
    public UploadStickerFileMethod setFile(@NotNull String name, @NotNull InputStream inputStream) {
        method.setPngSticker(name, inputStream);
        return this;
    }

    @Override
    public UploadStickerFileMethod setFile(@NotNull InputFile file) {
        if (file.getNewMediaFile() != null) {
            return setFile(file.getNewMediaFile());
        }
        return setFile(file.getMediaName(), file.getNewMediaStream());
    }

    @Override
    public File execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super File> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer);
    }
}
