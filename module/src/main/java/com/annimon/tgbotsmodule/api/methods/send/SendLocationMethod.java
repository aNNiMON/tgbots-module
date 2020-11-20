package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.LocationMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendLocationMethod implements
        ReplyMarkupSupportedMessageMethod<SendLocationMethod, Message>,
        LocationMethod<SendLocationMethod, Message> {

    private final SendLocation method;

    public SendLocationMethod() {
        this(new SendLocation());
    }

    public SendLocationMethod(@NotNull SendLocation method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendLocationMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendLocationMethod setReplyToMessageId(@NotNull Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendLocationMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendLocationMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendLocationMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public Double getLatitude() {
        return method.getLatitude();
    }

    @Override
    public SendLocationMethod setLatitude(@NotNull Double latitude) {
        method.setLatitude(latitude);
        return this;
    }

    @Override
    public Double getLongitude() {
        return method.getLongitude();
    }

    @Override
    public SendLocationMethod setLongitude(@NotNull Double longitude) {
        method.setLongitude(longitude);
        return this;
    }

    public Integer getLivePeriod() {
        return method.getLivePeriod();
    }

    public SendLocationMethod setLivePeriod(Integer livePeriod) {
        method.setLivePeriod(livePeriod);
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