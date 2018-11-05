package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InputFileMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.File;
import java.io.InputStream;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetChatPhotoMethod implements
        ChatMethod<SetChatPhotoMethod, Boolean>,
        InputFileMethod<SetChatPhotoMethod, Boolean> {

    private final SetChatPhoto method;
    private InputFile inputFile;

    public SetChatPhotoMethod() {
        this(new SetChatPhoto());
    }

    public SetChatPhotoMethod(@NotNull SetChatPhoto method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SetChatPhotoMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public InputFile getFile() {
        return inputFile;
    }

    @Override
    public SetChatPhotoMethod setFile(String fileId) {
        throw new UnsupportedOperationException("SetChatPhoto doesn't support setting files as fileId");
    }

    @Override
    public SetChatPhotoMethod setFile(@NotNull File file) {
        method.setPhoto(file);
        inputFile = new InputFile(file, file.getName());
        return this;
    }

    @Override
    public SetChatPhotoMethod setFile(@NotNull String name, @NotNull InputStream inputStream) {
        method.setNewPhoto(name, inputStream);
        inputFile = new InputFile(inputStream, name);
        return this;
    }

    @Override
    public SetChatPhotoMethod setFile(@NotNull InputFile file) {
        if (file.getNewMediaFile() != null) {
            return setFile(file.getNewMediaFile());
        }
        return setFile(file.getMediaName(), file.getNewMediaStream());
    }

    @Override
    public Boolean execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Boolean> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer);
    }
}
