package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TextMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.WebPagePreviewMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.LinkPreviewOptions;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class EditMessageTextMethod implements
        InlineOrChatMessageMethod<EditMessageTextMethod, Serializable>,
        InlineKeyboardMarkupMethod<EditMessageTextMethod, Serializable>,
        ParseModeMethod<EditMessageTextMethod, Serializable>,
        WebPagePreviewMethod<EditMessageTextMethod, Serializable>,
        TextMethod<EditMessageTextMethod, Serializable>,
        BusinessConnectionMethod<EditMessageTextMethod, Serializable> {

    private final EditMessageText.EditMessageTextBuilder<?, ?> method;

    public EditMessageTextMethod() {
        this(EditMessageText.builder());
    }

    public EditMessageTextMethod(@NotNull EditMessageText.EditMessageTextBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditMessageTextMethod setChatId(@NotNull String chatId) {
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
    public EditMessageTextMethod setMessageId(@NotNull Integer messageId) {
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
    public EditMessageTextMethod setInlineMessageId(@NotNull String inlineMessageId) {
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
    public EditMessageTextMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public EditMessageTextMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getEntities();
    }

    @Override
    public EditMessageTextMethod setEntities(List<MessageEntity> entities) {
        method.entities(entities);
        return this;
    }

    @Override
    public String getText() {
        return method.build().getText();
    }

    @Override
    public EditMessageTextMethod setText(@NotNull String text) {
        method.text(text);
        return this;
    }

    @Override
    public boolean isWebPagePreviewDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableWebPagePreview());
    }

    public EditMessageTextMethod disableWebPagePreview() {
        method.disableWebPagePreview(true);
        return this;
    }


    public EditMessageTextMethod enableWebPagePreview() {
        method.disableWebPagePreview(false);
        return this;
    }

    public LinkPreviewOptions getLinkPreviewOptions() {
        return method.build().getLinkPreviewOptions();
    }

    public EditMessageTextMethod setLinkPreviewOptions(LinkPreviewOptions options) {
        method.linkPreviewOptions(options);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public EditMessageTextMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Serializable call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Serializable> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}