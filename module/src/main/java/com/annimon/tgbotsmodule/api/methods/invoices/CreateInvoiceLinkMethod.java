package com.annimon.tgbotsmodule.api.methods.invoices;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.invoices.CreateInvoiceLink;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;

public class CreateInvoiceLinkMethod implements BusinessConnectionMethod<CreateInvoiceLinkMethod, String> {

    private final CreateInvoiceLink.CreateInvoiceLinkBuilder<?, ?> method;

    public CreateInvoiceLinkMethod() {
        this(CreateInvoiceLink.builder());
    }

    public CreateInvoiceLinkMethod(@NotNull CreateInvoiceLink.CreateInvoiceLinkBuilder<?, ?> method) {
        this.method = method;
    }

    public String getTitle() {
        return method.build().getTitle();
    }

    public CreateInvoiceLinkMethod setTitle(String title) {
        method.title(title);
        return this;
    }

    public String getDescription() {
        return method.build().getDescription();
    }

    public CreateInvoiceLinkMethod setDescription(String description) {
        method.description(description);
        return this;
    }

    public String getPayload() {
        return method.build().getPayload();
    }

    public CreateInvoiceLinkMethod setPayload(String payload) {
        method.payload(payload);
        return this;
    }

    public String getProviderToken() {
        return method.build().getProviderToken();
    }

    public CreateInvoiceLinkMethod setProviderToken(String providerToken) {
        method.providerToken(providerToken);
        return this;
    }

    public String getCurrency() {
        return method.build().getCurrency();
    }

    public CreateInvoiceLinkMethod setCurrency(String currency) {
        method.currency(currency);
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return method.build().getPrices();
    }

    public CreateInvoiceLinkMethod setPrices(List<LabeledPrice> prices) {
        method.prices(prices);
        return this;
    }

    public String getPhotoUrl() {
        return method.build().getPhotoUrl();
    }

    public CreateInvoiceLinkMethod setPhotoUrl(String photoUrl) {
        method.photoUrl(photoUrl);
        return this;
    }

    public Integer getPhotoSize() {
        return method.build().getPhotoSize();
    }

    public CreateInvoiceLinkMethod setPhotoSize(Integer photoSize) {
        method.photoSize(photoSize);
        return this;
    }

    public Integer getPhotoWidth() {
        return method.build().getPhotoWidth();
    }

    public CreateInvoiceLinkMethod setPhotoWidth(Integer photoWidth) {
        method.photoWidth(photoWidth);
        return this;
    }

    public Integer getPhotoHeight() {
        return method.build().getPhotoHeight();
    }

    public CreateInvoiceLinkMethod setPhotoHeight(Integer photoHeight) {
        method.photoHeight(photoHeight);
        return this;
    }

    public Boolean getNeedName() {
        return method.build().getNeedName();
    }

    public CreateInvoiceLinkMethod setNeedName(Boolean needName) {
        method.needName(needName);
        return this;
    }

    public Boolean getNeedPhoneNumber() {
        return method.build().getNeedPhoneNumber();
    }

    public CreateInvoiceLinkMethod setNeedPhoneNumber(Boolean needPhoneNumber) {
        method.needPhoneNumber(needPhoneNumber);
        return this;
    }

    public Boolean getNeedEmail() {
        return method.build().getNeedEmail();
    }

    public CreateInvoiceLinkMethod setNeedEmail(Boolean needEmail) {
        method.needEmail(needEmail);
        return this;
    }

    public Boolean getNeedShippingAddress() {
        return method.build().getNeedShippingAddress();
    }

    public CreateInvoiceLinkMethod setNeedShippingAddress(Boolean needShippingAddress) {
        method.needShippingAddress(needShippingAddress);
        return this;
    }

    public Boolean getIsFlexible() {
        return method.build().getIsFlexible();
    }

    public CreateInvoiceLinkMethod setIsFlexible(Boolean flexible) {
        method.isFlexible(flexible);
        return this;
    }

    public Boolean getSendEmailToProvider() {
        return method.build().getSendEmailToProvider();
    }

    public CreateInvoiceLinkMethod setSendEmailToProvider(Boolean sendEmailToProvider) {
        method.sendEmailToProvider(sendEmailToProvider);
        return this;
    }

    public Boolean getSendPhoneNumberToProvider() {
        return method.build().getSendPhoneNumberToProvider();
    }

    public CreateInvoiceLinkMethod setSendPhoneNumberToProvider(Boolean sendPhoneNumberToProvider) {
        method.sendPhoneNumberToProvider(sendPhoneNumberToProvider);
        return this;
    }

    public String getProviderData() {
        return method.build().getProviderData();
    }

    public CreateInvoiceLinkMethod setProviderData(String providerData) {
        method.providerData(providerData);
        return this;
    }

    public Integer getMaxTipAmount() {
        return method.build().getMaxTipAmount();
    }

    public CreateInvoiceLinkMethod setMaxTipAmount(Integer maxTipAmount) {
        method.maxTipAmount(maxTipAmount);
        return this;
    }

    public List<Integer> getSuggestedTipAmounts() {
        return method.build().getSuggestedTipAmounts();
    }

    public CreateInvoiceLinkMethod setSuggestedTipAmounts(List<Integer> suggestedTipAmounts) {
        method.suggestedTipAmounts(suggestedTipAmounts);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public CreateInvoiceLinkMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Integer getSubscriptionPeriod() {
        return method.build().getSubscriptionPeriod();
    }

    public CreateInvoiceLinkMethod setSubscriptionPeriod(Integer period) {
        method.subscriptionPeriod(period);
        return this;
    }

    @Override
    public String call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<String> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
