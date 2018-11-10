package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatStickerSet;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetChatStickerSetMethod implements ChatMethod<SetChatStickerSetMethod, Boolean> {

    private final SetChatStickerSet method;

    public SetChatStickerSetMethod() {
        this(new SetChatStickerSet());
    }

    public SetChatStickerSetMethod(@NotNull SetChatStickerSet method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SetChatStickerSetMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public String getStickerSetName() {
        return method.getStickerSetName();
    }

    public SetChatStickerSetMethod setStickerSetName(@NotNull String stickerSetName) {
        method.setStickerSetName(stickerSetName);
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
