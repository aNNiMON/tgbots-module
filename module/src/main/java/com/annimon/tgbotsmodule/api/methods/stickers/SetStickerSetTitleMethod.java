package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetTitle;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetStickerSetTitleMethod implements Method<Boolean> {

    private final SetStickerSetTitle method;

    public SetStickerSetTitleMethod() {
        this(new SetStickerSetTitle());
    }

    public SetStickerSetTitleMethod(@NotNull SetStickerSetTitle method) {
        this.method = method;
    }

    public String getName() {
        return method.getName();
    }

    public SetStickerSetTitleMethod setName(@NotNull String name) {
        method.setName(name);
        return this;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public SetStickerSetTitleMethod setTitle(@NotNull String title) {
        method.setTitle(title);
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
