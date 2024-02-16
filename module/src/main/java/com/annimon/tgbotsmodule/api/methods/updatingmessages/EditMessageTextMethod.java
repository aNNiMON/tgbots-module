package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TextMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.WebPagePreviewMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.LinkPreviewOptions;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditMessageTextMethod implements
        InlineOrChatMessageMethod<EditMessageTextMethod, Serializable>,
        InlineKeyboardMarkupMethod<EditMessageTextMethod, Serializable>,
        ParseModeMethod<EditMessageTextMethod, Serializable>,
        WebPagePreviewMethod<EditMessageTextMethod, Serializable>,
        TextMethod<EditMessageTextMethod, Serializable> {

    private final EditMessageText method;

    public EditMessageTextMethod() {
        this(new EditMessageText());
    }

    public EditMessageTextMethod(@NotNull EditMessageText method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public EditMessageTextMethod setChatId(@NotNull String chatId) {
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
    public EditMessageTextMethod setMessageId(@NotNull Integer messageId) {
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
    public EditMessageTextMethod setInlineMessageId(@NotNull String inlineMessageId) {
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
    public EditMessageTextMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.getParseMode();
    }

    @Override
    public EditMessageTextMethod setParseMode(String parseMode) {
        method.setParseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.getEntities();
    }

    @Override
    public EditMessageTextMethod setEntities(List<MessageEntity> entities) {
        method.setEntities(entities);
        return this;
    }

    @Override
    public String getText() {
        return method.getText();
    }

    @Override
    public EditMessageTextMethod setText(@NotNull String text) {
        method.setText(text);
        return this;
    }

    @Override
    public boolean isWebPagePreviewDisabled() {
        return Boolean.TRUE.equals(method.getDisableWebPagePreview());
    }

    public EditMessageTextMethod disableWebPagePreview() {
        method.disableWebPagePreview();
        return this;
    }


    public EditMessageTextMethod enableWebPagePreview() {
        method.enableWebPagePreview();
        return this;
    }

    public LinkPreviewOptions getLinkPreviewOptions() {
        return method.getLinkPreviewOptions();
    }

    public EditMessageTextMethod setLinkPreviewOptions(LinkPreviewOptions options) {
        method.setLinkPreviewOptions(options);
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