package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditMessageCaptionMethod implements
        InlineOrChatMessageMethod<EditMessageCaptionMethod, Serializable>,
        InlineKeyboardMarkupMethod<EditMessageCaptionMethod, Serializable>,
        ParseModeMethod<EditMessageCaptionMethod, Serializable>,
        CaptionMethod<EditMessageCaptionMethod, Serializable> {

    private final EditMessageCaption method;
    private String parseMode;

    public EditMessageCaptionMethod() {
        this(new EditMessageCaption());
    }

    public EditMessageCaptionMethod(@NotNull EditMessageCaption method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public EditMessageCaptionMethod setChatId(@NotNull String chatId) {
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
    public EditMessageCaptionMethod setMessageId(@NotNull Integer messageId) {
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
    public EditMessageCaptionMethod setInlineMessageId(@NotNull String inlineMessageId) {
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
    public EditMessageCaptionMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public String getParseMode() {
        // Some library methods doesn't provide getParseMode()
        return parseMode;
    }

    @Override
    public EditMessageCaptionMethod setParseMode(String parseMode) {
        this.parseMode = parseMode;
        method.setParseMode(parseMode);
        return this;
    }

    @Override
    public String getCaption() {
        return method.getCaption();
    }

    @Override
    public EditMessageCaptionMethod setCaption(String caption) {
        method.setCaption(caption);
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