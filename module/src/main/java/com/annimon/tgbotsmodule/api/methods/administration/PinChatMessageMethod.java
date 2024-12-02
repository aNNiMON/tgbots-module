package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.pinnedmessages.PinChatMessage;

public class PinChatMessageMethod implements
        ChatMessageMethod<PinChatMessageMethod, Boolean>,
        NotificationMethod<PinChatMessageMethod, Boolean>,
        BusinessConnectionMethod<PinChatMessageMethod, Boolean> {

    private final PinChatMessage.PinChatMessageBuilder<?, ?> method;

    public PinChatMessageMethod() {
        this(PinChatMessage.builder());
    }

    public PinChatMessageMethod(@NotNull PinChatMessage.PinChatMessageBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public PinChatMessageMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public PinChatMessageMethod setMessageId(@NotNull Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public PinChatMessageMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public PinChatMessageMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public PinChatMessageMethod setNotificationEnabled(boolean status) {
        method.disableNotification(!status);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public PinChatMessageMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
