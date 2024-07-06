package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionAboveMediaMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class EditMessageCaptionMethod implements
        InlineOrChatMessageMethod<EditMessageCaptionMethod, Serializable>,
        InlineKeyboardMarkupMethod<EditMessageCaptionMethod, Serializable>,
        ParseModeMethod<EditMessageCaptionMethod, Serializable>,
        CaptionMethod<EditMessageCaptionMethod, Serializable>,
        CaptionAboveMediaMethod<EditMessageCaptionMethod, Serializable>,
        BusinessConnectionMethod<EditMessageCaptionMethod, Serializable> {

    private final EditMessageCaption.EditMessageCaptionBuilder method;

    public EditMessageCaptionMethod() {
        this(EditMessageCaption.builder());
    }

    public EditMessageCaptionMethod(@NotNull EditMessageCaption.EditMessageCaptionBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditMessageCaptionMethod setChatId(@NotNull String chatId) {
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
    public EditMessageCaptionMethod setMessageId(@NotNull Integer messageId) {
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
    public EditMessageCaptionMethod setInlineMessageId(@NotNull String inlineMessageId) {
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
    public EditMessageCaptionMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public EditMessageCaptionMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public EditMessageCaptionMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }

    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public EditMessageCaptionMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    @Override
    public Boolean getShowCaptionAboveMedia() {
        return method.build().getShowCaptionAboveMedia();
    }

    @Override
    public EditMessageCaptionMethod setShowCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        method.showCaptionAboveMedia(showCaptionAboveMedia);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public EditMessageCaptionMethod setBusinessConnectionId(String id) {
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