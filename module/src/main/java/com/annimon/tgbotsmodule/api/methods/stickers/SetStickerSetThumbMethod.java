package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetThumb;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetStickerSetThumbMethod implements
        UserMethod<SetStickerSetThumbMethod, Boolean>,
        InputFileMethod<SetStickerSetThumbMethod, Boolean> {

    private final SetStickerSetThumb method;

    public SetStickerSetThumbMethod() {
        this(new SetStickerSetThumb());
    }

    public SetStickerSetThumbMethod(@NotNull SetStickerSetThumb method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public SetStickerSetThumbMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getThumb();
    }

    @Override
    public SetStickerSetThumbMethod setFile(@NotNull InputFile file) {
        method.setThumb(file);
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
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
