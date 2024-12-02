package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public class SetChatPhotoMethod implements
        ChatMethod<SetChatPhotoMethod, Boolean>,
        InputFileMethod<SetChatPhotoMethod, Boolean> {

    private final SetChatPhoto.SetChatPhotoBuilder<?, ?> method;

    public SetChatPhotoMethod() {
        this(SetChatPhoto.builder());
    }

    public SetChatPhotoMethod(@NotNull SetChatPhoto.SetChatPhotoBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetChatPhotoMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.build().getPhoto();
    }

    @Override
    public SetChatPhotoMethod setFile(@NotNull InputFile file) {
        method.photo(file);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
