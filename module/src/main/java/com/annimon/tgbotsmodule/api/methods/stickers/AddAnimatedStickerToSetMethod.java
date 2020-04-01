package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.File;
import java.io.InputStream;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.stickers.MaskPosition;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class AddAnimatedStickerToSetMethod implements
        UserMethod<AddAnimatedStickerToSetMethod, Boolean>,
        InputFileMethod<AddAnimatedStickerToSetMethod, Boolean> {

    private final AddStickerToSet method;

    public AddAnimatedStickerToSetMethod() {
        this(new AddStickerToSet());
    }

    public AddAnimatedStickerToSetMethod(@NotNull AddStickerToSet method) {
        this.method = method;
    }

    @Override
    public Integer getUserId() {
        return method.getUserId();
    }

    @Override
    public AddAnimatedStickerToSetMethod setUserId(@NotNull Integer userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getTgsSticker();
    }

    @Override
    public AddAnimatedStickerToSetMethod setFile(@NotNull String fileId) {
        throw new UnsupportedOperationException("Setting stickers as fileId not supported");
    }

    @Override
    public AddAnimatedStickerToSetMethod setFile(@NotNull File file) {
        method.setTgsSticker(file);
        return this;
    }

    @Override
    public AddAnimatedStickerToSetMethod setFile(@NotNull String name, @NotNull InputStream inputStream) {
        method.setTgsSticker(name, inputStream);
        return this;
    }

    @Override
    public AddAnimatedStickerToSetMethod setFile(@NotNull InputFile file) {
        if (file.getNewMediaFile() != null) {
            return setFile(file.getNewMediaFile());
        }
        if (file.getNewMediaStream() != null) {
            return setFile(file.getMediaName(), file.getNewMediaStream());
        }
        return setFile(file.getAttachName());
    }

    public String getName() {
        return method.getName();
    }

    public AddAnimatedStickerToSetMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    public String getEmojis() {
        return method.getEmojis();
    }

    public AddAnimatedStickerToSetMethod setEmojis(@NotNull String emojis) {
        method.setEmojis(emojis);
        return this;
    }

    public MaskPosition getMaskPosition() {
        return method.getMaskPosition();
    }

    public AddAnimatedStickerToSetMethod setMaskPosition(MaskPosition maskPosition) {
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
