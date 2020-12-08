package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.LocationMethod;
import com.annimon.tgbotsmodule.api.methods.send.SendLocationMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageLiveLocation;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditMessageLiveLocationMethod implements
        InlineOrChatMessageMethod<EditMessageLiveLocationMethod, Serializable>,
        InlineKeyboardMarkupMethod<EditMessageLiveLocationMethod, Serializable>,
        LocationMethod<EditMessageLiveLocationMethod, Serializable> {

    private final EditMessageLiveLocation method;

    public EditMessageLiveLocationMethod() {
        this(new EditMessageLiveLocation());
    }

    public EditMessageLiveLocationMethod(@NotNull EditMessageLiveLocation method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public EditMessageLiveLocationMethod setChatId(@NotNull String chatId) {
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
    public EditMessageLiveLocationMethod setMessageId(@NotNull Integer messageId) {
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
    public EditMessageLiveLocationMethod setInlineMessageId(@NotNull String inlineMessageId) {
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
    public EditMessageLiveLocationMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public Double getLatitude() {
        return method.getLatitude();
    }

    @Override
    public EditMessageLiveLocationMethod setLatitude(@NotNull Double latitude) {
        method.setLatitude(latitude);
        return this;
    }

    @Override
    public Double getLongitude() {
        return method.getLongitude();
    }

    @Override
    public EditMessageLiveLocationMethod setLongitude(@NotNull Double longitude) {
        method.setLongitude(longitude);
        return this;
    }

    public Integer getHeading() {
        return method.getHeading();
    }

    public EditMessageLiveLocationMethod setHeading(Integer heading) {
        method.setHeading(heading);
        return this;
    }

    public Double getHorizontalAccuracy() {
        return method.getHorizontalAccuracy();
    }

    public EditMessageLiveLocationMethod setHorizontalAccuracy(Double accuracy) {
        method.setHorizontalAccuracy(accuracy);
        return this;
    }

    // TODO proximity_alert_radius

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