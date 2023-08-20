package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.SetCustomEmojiStickerSetThumbnail;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetCustomEmojiStickerSetThumbnailMethod implements Method<Boolean> {

    private final SetCustomEmojiStickerSetThumbnail method;

    public SetCustomEmojiStickerSetThumbnailMethod() {
        this(new SetCustomEmojiStickerSetThumbnail());
    }

    public SetCustomEmojiStickerSetThumbnailMethod(@NotNull SetCustomEmojiStickerSetThumbnail method) {
        this.method = method;
    }

    public String getName() {
        return method.getName();
    }

    public SetCustomEmojiStickerSetThumbnailMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    public String getCustomEmojiId() {
        return method.getCustomEmojiId();
    }

    public SetCustomEmojiStickerSetThumbnailMethod setCustomEmojiId(@NotNull String customEmojiId) {
        method.setCustomEmojiId(customEmojiId);
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
