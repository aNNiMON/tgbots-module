package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.DeleteChatStickerSet;

public class DeleteChatStickerSetMethod implements ChatMethod<DeleteChatStickerSetMethod, Boolean> {

    private final DeleteChatStickerSet.DeleteChatStickerSetBuilder method;

    public DeleteChatStickerSetMethod() {
        this(DeleteChatStickerSet.builder());
    }

    public DeleteChatStickerSetMethod(@NotNull DeleteChatStickerSet.DeleteChatStickerSetBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public DeleteChatStickerSetMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
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
