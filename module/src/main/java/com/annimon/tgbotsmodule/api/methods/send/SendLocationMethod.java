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
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendLocationMethod implements
        ReplyMarkupSupportedMessageMethod<SendLocationMethod, Message>,
        LocationMethod<SendLocationMethod, Message>,
        ProtectedContentMethod<SendLocationMethod, Message>,
        AllowPaidBroadcastMethod<SendLocationMethod, Message>,
        MessageEffectMethod<SendLocationMethod, Message>,
        BusinessConnectionMethod<SendLocationMethod, Message> {

    private final SendLocation.SendLocationBuilder<?, ?> method;

    public SendLocationMethod() {
        this(SendLocation.builder());
    }

    public SendLocationMethod(@NotNull SendLocation.SendLocationBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendLocationMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendLocationMethod setReplyToMessageId(@NotNull Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendLocationMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendLocationMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendLocationMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendLocationMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendLocationMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public Double getLatitude() {
        return method.build().getLatitude();
    }

    @Override
    public SendLocationMethod setLatitude(@NotNull Double latitude) {
        method.latitude(latitude);
        return this;
    }

    @Override
    public Double getLongitude() {
        return method.build().getLongitude();
    }

    @Override
    public SendLocationMethod setLongitude(@NotNull Double longitude) {
        method.longitude(longitude);
        return this;
    }

    public Integer getLivePeriod() {
        return method.build().getLivePeriod();
    }

    public SendLocationMethod setLivePeriod(Integer livePeriod) {
        method.livePeriod(livePeriod);
        return this;
    }

    public Integer getHeading() {
        return method.build().getHeading();
    }

    public SendLocationMethod setHeading(Integer heading) {
        method.heading(heading);
        return this;
    }

    public Double getHorizontalAccuracy() {
        return method.build().getHorizontalAccuracy();
    }

    public SendLocationMethod setHorizontalAccuracy(Double accuracy) {
        method.horizontalAccuracy(accuracy);
        return this;
    }

    public Integer getProximityAlertRadius() {
        return method.build().getProximityAlertRadius();
    }

    public SendLocationMethod setProximityAlertRadius(Integer proximityAlertRadius) {
        method.proximityAlertRadius(proximityAlertRadius);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendLocationMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendLocationMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendLocationMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendLocationMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendLocationMethod setAllowPaidBroadcast(Boolean flag) {
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