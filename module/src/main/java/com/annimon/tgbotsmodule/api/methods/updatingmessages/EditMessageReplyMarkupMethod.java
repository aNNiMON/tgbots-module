package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditMessageReplyMarkupMethod implements
        InlineOrChatMessageMethod<EditMessageReplyMarkupMethod, Serializable>,
        InlineKeyboardMarkupMethod<EditMessageReplyMarkupMethod, Serializable> {

    private final EditMessageReplyMarkup method;

    public EditMessageReplyMarkupMethod() {
        this(new EditMessageReplyMarkup());
    }

    public EditMessageReplyMarkupMethod(@NotNull EditMessageReplyMarkup method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public EditMessageReplyMarkupMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        // Clear inline message id
        method.setInlineMessageId(null);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.getMessageId();
    }

    @Override
    public EditMessageReplyMarkupMethod setMessageId(@NotNull Integer messageId) {
        method.setMessageId(messageId);
        // Clear inline message id
        method.setInlineMessageId(null);
        return this;
    }

    @Override
    public String getInlineMessageId() {
        return method.getInlineMessageId();
    }

    @Override
    public EditMessageReplyMarkupMethod setInlineMessageId(@NotNull String inlineMessageId) {
        method.setInlineMessageId(inlineMessageId);
        // Clear chat id and message id
        method.setChatId((String) null);
        method.setMessageId(null);
        return this;
    }

    @Override
    public InlineKeyboardMarkup getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public EditMessageReplyMarkupMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public Serializable call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Serializable> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}