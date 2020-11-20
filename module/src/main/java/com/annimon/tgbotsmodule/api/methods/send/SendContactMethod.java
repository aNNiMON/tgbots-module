package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendContactMethod implements ReplyMarkupSupportedMessageMethod<SendContactMethod, Message> {

    private final SendContact method;

    public SendContactMethod() {
        this(new SendContact());
    }

    public SendContactMethod(@NotNull SendContact method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendContactMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendContactMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendContactMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendContactMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendContactMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    public String getPhoneNumber() {
        return method.getPhoneNumber();
    }

    public SendContactMethod setPhoneNumber(@NotNull String phoneNumber) {
        method.setPhoneNumber(phoneNumber);
        return this;
    }

    public String getFirstName() {
        return method.getFirstName();
    }

    public SendContactMethod setFirstName(@NotNull String firstName) {
        method.setFirstName(firstName);
        return this;
    }

    public String getLastName() {
        return method.getLastName();
    }

    public SendContactMethod setLastName(String lastName) {
        method.setLastName(lastName);
        return this;
    }

    public String getVCard() {
        return method.getVCard();
    }

    public SendContactMethod setVCard(String vCard) {
        method.setVCard(vCard);
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