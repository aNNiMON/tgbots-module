package com.annimon.tgbotsmodule.api.methods.invoices;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.invoices.CreateInvoiceLink;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CreateInvoiceLinkMethod implements Method<Message> {

    private final CreateInvoiceLink method;

    public CreateInvoiceLinkMethod() {
        this(new CreateInvoiceLink());
    }

    public CreateInvoiceLinkMethod(@NotNull CreateInvoiceLink method) {
        this.method = method;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public CreateInvoiceLinkMethod setTitle(String title) {
        method.setTitle(title);
        return this;
    }

    public String getDescription() {
        return method.getDescription();
    }

    public CreateInvoiceLinkMethod setDescription(String description) {
        method.setDescription(description);
        return this;
    }

    public String getPayload() {
        return method.getPayload();
    }

    public CreateInvoiceLinkMethod setPayload(String payload) {
        method.setPayload(payload);
        return this;
    }

    public String getProviderToken() {
        return method.getProviderToken();
    }

    public CreateInvoiceLinkMethod setProviderToken(String providerToken) {
        method.setProviderToken(providerToken);
        return this;
    }

    public String getCurrency() {
        return method.getCurrency();
    }

    public CreateInvoiceLinkMethod setCurrency(String currency) {
        method.setCurrency(currency);
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return method.getPrices();
    }

    public CreateInvoiceLinkMethod setPrices(List<LabeledPrice> prices) {
        method.setPrices(prices);
        return this;
    }

    public String getPhotoUrl() {
        return method.getPhotoUrl();
    }

    public CreateInvoiceLinkMethod setPhotoUrl(String photoUrl) {
        method.setPhotoUrl(photoUrl);
        return this;
    }

    public Integer getPhotoSize() {
        return method.getPhotoSize();
    }

    public CreateInvoiceLinkMethod setPhotoSize(Integer photoSize) {
        method.setPhotoSize(photoSize);
        return this;
    }

    public Integer getPhotoWidth() {
        return method.getPhotoWidth();
    }

    public CreateInvoiceLinkMethod setPhotoWidth(Integer photoWidth) {
        method.setPhotoWidth(photoWidth);
        return this;
    }

    public Integer getPhotoHeight() {
        return method.getPhotoHeight();
    }

    public CreateInvoiceLinkMethod setPhotoHeight(Integer photoHeight) {
        method.setPhotoHeight(photoHeight);
        return this;
    }

    public Boolean getNeedName() {
        return method.getNeedName();
    }

    public CreateInvoiceLinkMethod setNeedName(Boolean needName) {
        method.setNeedName(needName);
        return this;
    }

    public Boolean getNeedPhoneNumber() {
        return method.getNeedPhoneNumber();
    }

    public CreateInvoiceLinkMethod setNeedPhoneNumber(Boolean needPhoneNumber) {
        method.setNeedPhoneNumber(needPhoneNumber);
        return this;
    }

    public Boolean getNeedEmail() {
        return method.getNeedEmail();
    }

    public CreateInvoiceLinkMethod setNeedEmail(Boolean needEmail) {
        method.setNeedEmail(needEmail);
        return this;
    }

    public Boolean getNeedShippingAddress() {
        return method.getNeedShippingAddress();
    }

    public CreateInvoiceLinkMethod setNeedShippingAddress(Boolean needShippingAddress) {
        method.setNeedShippingAddress(needShippingAddress);
        return this;
    }

    public Boolean getIsFlexible() {
        return method.getIsFlexible();
    }

    public CreateInvoiceLinkMethod setIsFlexible(Boolean flexible) {
        method.setIsFlexible(flexible);
        return this;
    }

    public Boolean getSendEmailToProvider() {
        return method.getSendEmailToProvider();
    }

    public CreateInvoiceLinkMethod setSendEmailToProvider(Boolean sendEmailToProvider) {
        method.setSendEmailToProvider(sendEmailToProvider);
        return this;
    }

    public Boolean getSendPhoneNumberToProvider() {
        return method.getSendPhoneNumberToProvider();
    }

    public CreateInvoiceLinkMethod setSendPhoneNumberToProvider(Boolean sendPhoneNumberToProvider) {
        method.setSendPhoneNumberToProvider(sendPhoneNumberToProvider);
        return this;
    }

    public String getProviderData() {
        return method.getProviderData();
    }

    public CreateInvoiceLinkMethod setProviderData(String providerData) {
        method.setProviderData(providerData);
        return this;
    }

    public Integer getMaxTipAmount() {
        return method.getMaxTipAmount();
    }

    public CreateInvoiceLinkMethod setMaxTipAmount(Integer maxTipAmount) {
        method.setMaxTipAmount(maxTipAmount);
        return this;
    }

    public List<Integer> getSuggestedTipAmounts() {
        return method.getSuggestedTipAmounts();
    }

    public CreateInvoiceLinkMethod setSuggestedTipAmounts(List<Integer> suggestedTipAmounts) {
        method.setSuggestedTipAmounts(suggestedTipAmounts);
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
