package com.annimon.tgbotsmodule.api.methods.invoices;

import com.annimon.tgbotsmodule.api.methods.interfaces.AllowPaidBroadcastMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.DirectMessageTopicMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MessageEffectMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.SendableMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.SuggestedPostParametersMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.invoices.SendInvoice;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.suggestedpost.SuggestedPostParameters;

public class SendInvoiceMethod implements
        SendableMessageMethod<SendInvoiceMethod, Message>,
        InlineKeyboardMarkupMethod<SendInvoiceMethod, Message>,
        ProtectedContentMethod<SendInvoiceMethod, Message>,
        AllowPaidBroadcastMethod<SendInvoiceMethod, Message>,
        DirectMessageTopicMethod<SendInvoiceMethod, Message>,
        SuggestedPostParametersMethod<SendInvoiceMethod, Message>,
        MessageEffectMethod<SendInvoiceMethod, Message> {

    private final SendInvoice.SendInvoiceBuilder<?, ?> method;

    public SendInvoiceMethod() {
        this(SendInvoice.builder());
    }

    public SendInvoiceMethod(@NotNull SendInvoice.SendInvoiceBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendInvoiceMethod setChatId(long chatId) {
        method.chatId(Long.toString(chatId));
        return this;
    }

    @Override
    public SendInvoiceMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendInvoiceMethod setReplyToMessageId(@NotNull Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendInvoiceMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendInvoiceMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendInvoiceMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendInvoiceMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public SendInvoiceMethod setNotificationEnabled(boolean status) {
        method.disableNotification(!status);
        return this;
    }

    @Override
    public InlineKeyboardMarkup getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendInvoiceMethod setReplyMarkup(@NotNull InlineKeyboardMarkup replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    public String getTitle() {
        return method.build().getTitle();
    }

    public SendInvoiceMethod setTitle(String title) {
        method.title(title);
        return this;
    }

    public String getDescription() {
        return method.build().getDescription();
    }

    public SendInvoiceMethod setDescription(String description) {
        method.description(description);
        return this;
    }

    public String getPayload() {
        return method.build().getPayload();
    }

    public SendInvoiceMethod setPayload(String payload) {
        method.payload(payload);
        return this;
    }

    public String getProviderToken() {
        return method.build().getProviderToken();
    }

    public SendInvoiceMethod setProviderToken(String providerToken) {
        method.providerToken(providerToken);
        return this;
    }

    public String getStartParameter() {
        return method.build().getStartParameter();
    }

    public SendInvoiceMethod setStartParameter(String startParameter) {
        method.startParameter(startParameter);
        return this;
    }

    public String getCurrency() {
        return method.build().getCurrency();
    }

    public SendInvoiceMethod setCurrency(String currency) {
        method.currency(currency);
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return method.build().getPrices();
    }

    public SendInvoiceMethod setPrices(List<LabeledPrice> prices) {
        method.prices(prices);
        return this;
    }

    public String getPhotoUrl() {
        return method.build().getPhotoUrl();
    }

    public SendInvoiceMethod setPhotoUrl(String photoUrl) {
        method.photoUrl(photoUrl);
        return this;
    }

    public Integer getPhotoSize() {
        return method.build().getPhotoSize();
    }

    public SendInvoiceMethod setPhotoSize(Integer photoSize) {
        method.photoSize(photoSize);
        return this;
    }

    public Integer getPhotoWidth() {
        return method.build().getPhotoWidth();
    }

    public SendInvoiceMethod setPhotoWidth(Integer photoWidth) {
        method.photoWidth(photoWidth);
        return this;
    }

    public Integer getPhotoHeight() {
        return method.build().getPhotoHeight();
    }

    public SendInvoiceMethod setPhotoHeight(Integer photoHeight) {
        method.photoHeight(photoHeight);
        return this;
    }

    public Boolean getNeedName() {
        return method.build().getNeedName();
    }

    public SendInvoiceMethod setNeedName(Boolean needName) {
        method.needName(needName);
        return this;
    }

    public Boolean getNeedPhoneNumber() {
        return method.build().getNeedPhoneNumber();
    }

    public SendInvoiceMethod setNeedPhoneNumber(Boolean needPhoneNumber) {
        method.needPhoneNumber(needPhoneNumber);
        return this;
    }

    public Boolean getNeedEmail() {
        return method.build().getNeedEmail();
    }

    public SendInvoiceMethod setNeedEmail(Boolean needEmail) {
        method.needEmail(needEmail);
        return this;
    }

    public Boolean getNeedShippingAddress() {
        return method.build().getNeedShippingAddress();
    }

    public SendInvoiceMethod setNeedShippingAddress(Boolean needShippingAddress) {
        method.needShippingAddress(needShippingAddress);
        return this;
    }

    public Boolean getIsFlexible() {
        return method.build().getIsFlexible();
    }

    public SendInvoiceMethod setIsFlexible(Boolean flexible) {
        method.isFlexible(flexible);
        return this;
    }

    public String getProviderData() {
        return method.build().getProviderData();
    }

    public SendInvoiceMethod setProviderData(String providerData) {
        method.providerData(providerData);
        return this;
    }

    public Integer getMaxTipAmount() {
        return method.build().getMaxTipAmount();
    }

    public SendInvoiceMethod setMaxTipAmount(Integer maxTipAmount) {
        method.maxTipAmount(maxTipAmount);
        return this;
    }

    public List<Integer> getSuggestedTipAmounts() {
        return method.build().getSuggestedTipAmounts();
    }

    public SendInvoiceMethod setSuggestedTipAmounts(List<Integer> suggestedTipAmounts) {
        method.suggestedTipAmounts(suggestedTipAmounts);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendInvoiceMethod setAllowPaidBroadcast(Boolean flag) {
        method.allowPaidBroadcast(flag);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendInvoiceMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    public Boolean getSendEmailToProvider() {
        return method.build().getSendEmailToProvider();
    }

    public SendInvoiceMethod setSendEmailToProvider(Boolean sendEmailToProvider) {
        method.sendEmailToProvider(sendEmailToProvider);
        return this;
    }

    public Boolean getSendPhoneNumberToProvider() {
        return method.build().getSendPhoneNumberToProvider();
    }

    public SendInvoiceMethod setSendPhoneNumberToProvider(Boolean sendPhoneNumberToProvider) {
        method.sendPhoneNumberToProvider(sendPhoneNumberToProvider);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendInvoiceMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendInvoiceMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public Integer getDirectMessagesTopicId() {
        // TODO uncomment when available in Telegram Bots API
        // return method.build().getDirectMessagesTopicId();
        return null;
    }

    @Override
    public SendInvoiceMethod setDirectMessagesTopicId(Integer topicId) {
        // TODO uncomment when available in Telegram Bots API
        // method.directMessagesTopicId(topicId);
        return this;
    }

    @Override
    public SuggestedPostParameters getSuggestedPostParameters() {
        // TODO uncomment when available in Telegram Bots API
        // return method.build().getSuggestedPostParameters();
        return null;
    }

    @Override
    public SendInvoiceMethod setSuggestedPostParameters(SuggestedPostParameters parameters) {
        // TODO uncomment when available in Telegram Bots API
        // method.suggestedPostParameters(parameters);
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