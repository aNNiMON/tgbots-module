package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageThreadMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;

public class SendChatActionMethod implements
        ChatMessageThreadMethod<SendChatActionMethod, Boolean>,
        BusinessConnectionMethod<SendChatActionMethod, Boolean> {

    private final SendChatAction.SendChatActionBuilder method;

    public SendChatActionMethod() {
        this(SendChatAction.builder());
    }

    public SendChatActionMethod(@NotNull SendChatAction.SendChatActionBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendChatActionMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendChatActionMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    public ActionType getAction() {
        return method.build().getActionType();
    }

    public SendChatActionMethod setAction(@NotNull ActionType actionType) {
        method.action(actionType.toString());
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

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendChatActionMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }
}
