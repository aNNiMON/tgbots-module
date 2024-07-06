package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class EditMessageMediaMethod implements
        InlineOrChatMessageMethod<EditMessageMediaMethod, Serializable>,
        InlineKeyboardMarkupMethod<EditMessageMediaMethod, Serializable>,
        BusinessConnectionMethod<EditMessageMediaMethod, Serializable> {

    private final EditMessageMedia.EditMessageMediaBuilder method;

    public EditMessageMediaMethod() {
        this(EditMessageMedia.builder());
    }

    public EditMessageMediaMethod(@NotNull EditMessageMedia.EditMessageMediaBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditMessageMediaMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        // Clear inline message id
        method.inlineMessageId(null);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public EditMessageMediaMethod setMessageId(@NotNull Integer messageId) {
        method.messageId(messageId);
        // Clear inline message id
        method.inlineMessageId(null);
        return this;
    }

    @Override
    public String getInlineMessageId() {
        return method.build().getInlineMessageId();
    }

    @Override
    public EditMessageMediaMethod setInlineMessageId(@NotNull String inlineMessageId) {
        method.inlineMessageId(inlineMessageId);
        // Clear chat id and message id
        method.chatId((String) null);
        method.messageId(null);
        return this;
    }

    @Override
    public InlineKeyboardMarkup getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public EditMessageMediaMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    public InputMedia getMedia() {
        return method.build().getMedia();
    }

    public EditMessageMediaMethod setMedia(@NotNull InputMedia media) {
        method.media(media);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public EditMessageMediaMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Serializable call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Serializable> callAsync(CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}