package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TextMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.WebPagePreviewMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendMessageMethod implements
        ReplyMarkupSupportedMessageMethod<SendMessageMethod, Message>,
        ParseModeMethod<SendMessageMethod, Message>,
        WebPagePreviewMethod<SendMessageMethod, Message>,
        TextMethod<SendMessageMethod, Message> {

    private final SendMessage method;
    private String parseMode;

    public SendMessageMethod() {
        this(new SendMessage());
    }

    public SendMessageMethod(@NotNull SendMessage method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendMessageMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendMessageMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendMessageMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendMessageMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendMessageMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public String getParseMode() {
        // Some library methods doesn't provide getParseMode()
        return parseMode;
    }

    @Override
    public SendMessageMethod setParseMode(String parseMode) {
        this.parseMode = parseMode;
        method.setParseMode(parseMode);
        return this;
    }

    @Override
    public String getText() {
        return method.getText();
    }

    @Override
    public SendMessageMethod setText(@NotNull String text) {
        method.setText(text);
        return this;
    }

    @Override
    public boolean isWebPagePreviewDisabled() {
        return Boolean.TRUE.equals(method.getDisableWebPagePreview());
    }

    public SendMessageMethod disableWebPagePreview() {
        method.disableWebPagePreview();
        return this;
    }


    public SendMessageMethod enableWebPagePreview() {
        method.enableWebPagePreview();
        return this;
    }

    @Override
    public Message execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Message> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}