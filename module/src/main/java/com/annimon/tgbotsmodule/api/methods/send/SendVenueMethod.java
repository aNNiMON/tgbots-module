package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.AllowPaidBroadcastMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.LocationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MessageEffectMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendVenue;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendVenueMethod implements
        ReplyMarkupSupportedMessageMethod<SendVenueMethod, Message>,
        LocationMethod<SendVenueMethod, Message>,
        ProtectedContentMethod<SendVenueMethod, Message>,
        AllowPaidBroadcastMethod<SendVenueMethod, Message>,
        MessageEffectMethod<SendVenueMethod, Message>,
        BusinessConnectionMethod<SendVenueMethod, Message> {

    private final SendVenue.SendVenueBuilder<?, ?> method;

    public SendVenueMethod() {
        this(SendVenue.builder());
    }

    public SendVenueMethod(@NotNull SendVenue.SendVenueBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendVenueMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendVenueMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendVenueMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendVenueMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendVenueMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendVenueMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendVenueMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public Double getLatitude() {
        return method.build().getLatitude();
    }

    @Override
    public SendVenueMethod setLatitude(@NotNull Double latitude) {
        method.latitude(latitude);
        return this;
    }

    @Override
    public Double getLongitude() {
        return method.build().getLongitude();
    }

    @Override
    public SendVenueMethod setLongitude(@NotNull Double longitude) {
        method.longitude(longitude);
        return this;
    }

    public String getTitle() {
        return method.build().getTitle();
    }

    public SendVenueMethod setTitle(@NotNull String title) {
        method.title(title);
        return this;
    }

    public String getAddress() {
        return method.build().getAddress();
    }

    public SendVenueMethod setAddress(@NotNull String address) {
        method.address(address);
        return this;
    }

    public String getFoursquareId() {
        return method.build().getFoursquareId();
    }

    public SendVenueMethod setFoursquareId(String foursquareId) {
        method.foursquareId(foursquareId);
        return this;
    }

    public String getFoursquareType() {
        return method.build().getFoursquareType();
    }

    public SendVenueMethod setFoursquareType(String foursquareType) {
        method.foursquareType(foursquareType);
        return this;
    }

    public String getGooglePlaceId() {
        return method.build().getGooglePlaceId();
    }

    public SendVenueMethod setGooglePlaceId(String googlePlaceId) {
        method.googlePlaceId(googlePlaceId);
        return this;
    }

    public String getGooglePlaceType() {
        return method.build().getGooglePlaceType();
    }

    public SendVenueMethod setGooglePlaceType(String googlePlaceType) {
        method.googlePlaceType(googlePlaceType);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendVenueMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendVenueMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendVenueMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendVenueMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendVenueMethod setAllowPaidBroadcast(Boolean flag) {
        method.allowPaidBroadcast(flag);
        return this;
    }

    @Override
    public Message call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Message> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}