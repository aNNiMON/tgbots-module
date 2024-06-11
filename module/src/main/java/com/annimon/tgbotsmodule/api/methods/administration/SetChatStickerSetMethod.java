package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatStickerSet;

public class SetChatStickerSetMethod implements ChatMethod<SetChatStickerSetMethod, Boolean> {

    private final SetChatStickerSet.SetChatStickerSetBuilder method;

    public SetChatStickerSetMethod() {
        this(SetChatStickerSet.builder());
    }

    public SetChatStickerSetMethod(@NotNull SetChatStickerSet.SetChatStickerSetBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetChatStickerSetMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getStickerSetName() {
        return method.build().getStickerSetName();
    }

    public SetChatStickerSetMethod setStickerSetName(@NotNull String stickerSetName) {
        method.stickerSetName(stickerSetName);
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
