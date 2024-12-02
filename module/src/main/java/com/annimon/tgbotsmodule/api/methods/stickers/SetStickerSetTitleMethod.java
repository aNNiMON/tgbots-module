package com.annimon.tgbotsmodule.api.methods.stickers;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetTitle;

public class SetStickerSetTitleMethod implements Method<Boolean> {

    private final SetStickerSetTitle.SetStickerSetTitleBuilder<?, ?> method;

    public SetStickerSetTitleMethod() {
        this(SetStickerSetTitle.builder());
    }

    public SetStickerSetTitleMethod(@NotNull SetStickerSetTitle.SetStickerSetTitleBuilder<?, ?> method) {
        this.method = method;
    }

    public String getName() {
        return method.build().getName();
    }

    public SetStickerSetTitleMethod setName(@NotNull String name) {
        method.name(name);
        return this;
    }

    public String getTitle() {
        return method.build().getTitle();
    }

    public SetStickerSetTitleMethod setTitle(@NotNull String title) {
        method.title(title);
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
