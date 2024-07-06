package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineOrChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.LocationMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageLiveLocation;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class EditMessageLiveLocationMethod implements
        InlineOrChatMessageMethod<EditMessageLiveLocationMethod, Serializable>,
        InlineKeyboardMarkupMethod<EditMessageLiveLocationMethod, Serializable>,
        BusinessConnectionMethod<EditMessageLiveLocationMethod, Serializable>,
        LocationMethod<EditMessageLiveLocationMethod, Serializable> {

    private final EditMessageLiveLocation.EditMessageLiveLocationBuilder method;

    public EditMessageLiveLocationMethod() {
        this(EditMessageLiveLocation.builder());
    }

    public EditMessageLiveLocationMethod(@NotNull EditMessageLiveLocation.EditMessageLiveLocationBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditMessageLiveLocationMethod setChatId(@NotNull String chatId) {
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
    public EditMessageLiveLocationMethod setMessageId(@NotNull Integer messageId) {
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
    public EditMessageLiveLocationMethod setInlineMessageId(@NotNull String inlineMessageId) {
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
    public EditMessageLiveLocationMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public Double getLatitude() {
        return method.build().getLatitude();
    }

    @Override
    public EditMessageLiveLocationMethod setLatitude(@NotNull Double latitude) {
        method.latitude(latitude);
        return this;
    }

    @Override
    public Double getLongitude() {
        return method.build().getLongitude();
    }

    @Override
    public EditMessageLiveLocationMethod setLongitude(@NotNull Double longitude) {
        method.longitude(longitude);
        return this;
    }

    public Integer getLivePeriod() {
        return method.build().getLivePeriod();
    }

    public EditMessageLiveLocationMethod setLivePeriod(Integer livePeriod) {
        method.livePeriod(livePeriod);
        return this;
    }

    public Integer getHeading() {
        return method.build().getHeading();
    }

    public EditMessageLiveLocationMethod setHeading(Integer heading) {
        method.heading(heading);
        return this;
    }

    public Double getHorizontalAccuracy() {
        return method.build().getHorizontalAccuracy();
    }

    public EditMessageLiveLocationMethod setHorizontalAccuracy(Double accuracy) {
        method.horizontalAccuracy(accuracy);
        return this;
    }

    public Integer getProximityAlertRadius() {
        return method.build().getProximityAlertRadius();
    }

    public EditMessageLiveLocationMethod setProximityAlertRadius(Integer proximityAlertRadius) {
        method.proximityAlertRadius(proximityAlertRadius);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public EditMessageLiveLocationMethod setBusinessConnectionId(String id) {
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