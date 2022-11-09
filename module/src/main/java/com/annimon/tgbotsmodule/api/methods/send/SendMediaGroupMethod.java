package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.SendableMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendMediaGroupMethod implements
        SendableMessageMethod<SendMediaGroupMethod, ArrayList<Message>>,
        ProtectedContentMethod<SendMediaGroupMethod, ArrayList<Message>> {

    private final SendMediaGroup method;

    public SendMediaGroupMethod() {
        this(new SendMediaGroup());
    }

    public SendMediaGroupMethod(@NotNull SendMediaGroup method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendMediaGroupMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendMediaGroupMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.getMessageThreadId();
    }

    @Override
    public SendMediaGroupMethod setMessageThreadId(Integer messageThreadId) {
        method.setMessageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.getAllowSendingWithoutReply();
    }

    @Override
    public SendMediaGroupMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.setAllowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.getDisableNotification());
    }

    @Override
    public SendMediaGroupMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendMediaGroupMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    public List<InputMedia> getMedias() {
        return method.getMedias();
    }

    public SendMediaGroupMethod setMedias(@NotNull List<InputMedia> media) {
        method.setMedias(media);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.getProtectContent();
    }

    @Override
    public SendMediaGroupMethod setProtectContent(Boolean protectContent) {
        method.setProtectContent(protectContent);
        return this;
    }

    @Override
    public ArrayList<Message> call(@NotNull CommonAbsSender sender) {
        return listToArrayList(sender.call(method));
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super ArrayList<Message>> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, this::listToArrayList, apiExceptionConsumer);
    }

    private ArrayList<Message> listToArrayList(List<Message> messages) {
        if (messages == null) {
            return new ArrayList<>();
        }
        if (messages instanceof ArrayList) {
            return (ArrayList<Message>) messages;
        }
        return new ArrayList<>(messages);
    }
}