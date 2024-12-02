package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.AllowPaidBroadcastMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MessageEffectMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendContactMethod implements
        ReplyMarkupSupportedMessageMethod<SendContactMethod, Message>,
        ProtectedContentMethod<SendContactMethod, Message>,
        AllowPaidBroadcastMethod<SendContactMethod, Message>,
        MessageEffectMethod<SendContactMethod, Message>,
        BusinessConnectionMethod<SendContactMethod, Message> {

    private final SendContact.SendContactBuilder<?, ?> method;

    public SendContactMethod() {
        this(SendContact.builder());
    }

    public SendContactMethod(@NotNull SendContact.SendContactBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendContactMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendContactMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendContactMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendContactMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendContactMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendContactMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendContactMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    public String getPhoneNumber() {
        return method.build().getPhoneNumber();
    }

    public SendContactMethod setPhoneNumber(@NotNull String phoneNumber) {
        method.phoneNumber(phoneNumber);
        return this;
    }

    public String getFirstName() {
        return method.build().getFirstName();
    }

    public SendContactMethod setFirstName(@NotNull String firstName) {
        method.firstName(firstName);
        return this;
    }

    public String getLastName() {
        return method.build().getLastName();
    }

    public SendContactMethod setLastName(String lastName) {
        method.lastName(lastName);
        return this;
    }

    public String getVCard() {
        return method.build().getVCard();
    }

    public SendContactMethod setVCard(String vCard) {
        method.vCard(vCard);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendContactMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendContactMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendContactMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendContactMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendContactMethod setAllowPaidBroadcast(Boolean flag) {
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