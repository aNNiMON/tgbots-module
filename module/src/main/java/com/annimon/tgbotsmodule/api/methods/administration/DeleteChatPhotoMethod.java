package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.DeleteChatPhoto;

public class DeleteChatPhotoMethod implements ChatMethod<DeleteChatPhotoMethod, Boolean> {

    private final DeleteChatPhoto.DeleteChatPhotoBuilder method;

    public DeleteChatPhotoMethod() {
        this(DeleteChatPhoto.builder());
    }

    public DeleteChatPhotoMethod(@NotNull DeleteChatPhoto.DeleteChatPhotoBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public DeleteChatPhotoMethod setChatId(@NotNull String chatId) {
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
