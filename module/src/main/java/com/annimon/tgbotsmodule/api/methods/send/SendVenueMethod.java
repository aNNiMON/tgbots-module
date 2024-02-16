package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.LocationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendVenue;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendVenueMethod implements
        ReplyMarkupSupportedMessageMethod<SendVenueMethod, Message>,
        LocationMethod<SendVenueMethod, Message>,
        ProtectedContentMethod<SendVenueMethod, Message> {

    private final SendVenue method;

    public SendVenueMethod() {
        this(new SendVenue());
    }

    public SendVenueMethod(@NotNull SendVenue method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendVenueMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendVenueMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    @Override
    public SendVenueMethod setMessageThreadId(Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.getAllowSendingWithoutReply();
    }

    @Override
    public SendVenueMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.setAllowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendVenueMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendVenueMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendVenueMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public Double getLatitude() {
        return method.getLatitude();
    }

    @Override
    public SendVenueMethod setLatitude(@NotNull Double latitude) {
        method.setLatitude(latitude);
        return this;
    }

    @Override
    public Double getLongitude() {
        return method.getLongitude();
    }

    @Override
    public SendVenueMethod setLongitude(@NotNull Double longitude) {
        method.setLongitude(longitude);
        return this;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public SendVenueMethod setTitle(@NotNull String title) {
        method.setTitle(title);
        return this;
    }

    public String getAddress() {
        return method.getAddress();
    }

    public SendVenueMethod setAddress(@NotNull String address) {
        method.setAddress(address);
        return this;
    }

    public String getFoursquareId() {
        return method.getFoursquareId();
    }

    public SendVenueMethod setFoursquareId(String foursquareId) {
        method.setFoursquareId(foursquareId);
        return this;
    }

    public String getFoursquareType() {
        return method.getFoursquareType();
    }

    public SendVenueMethod setFoursquareType(String foursquareType) {
        method.setFoursquareType(foursquareType);
        return this;
    }

    public String getGooglePlaceId() {
        return method.getGooglePlaceId();
    }

    public SendVenueMethod setGooglePlaceId(String googlePlaceId) {
        method.setGooglePlaceId(googlePlaceId);
        return this;
    }

    public String getGooglePlaceType() {
        return method.getGooglePlaceType();
    }

    public SendVenueMethod setGooglePlaceType(String googlePlaceType) {
        method.setGooglePlaceType(googlePlaceType);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.getProtectContent();
    }

    @Override
    public SendVenueMethod setProtectContent(Boolean protectContent) {
        method.setProtectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.getReplyParameters();
    }

    @Override
    public SendVenueMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.setReplyParameters(replyParameters);
        return this;
    }

    @Override
    public Message call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Message> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}