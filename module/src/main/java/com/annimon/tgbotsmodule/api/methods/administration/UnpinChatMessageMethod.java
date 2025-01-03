package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.pinnedmessages.UnpinChatMessage;

public class UnpinChatMessageMethod implements
        ChatMessageMethod<UnpinChatMessageMethod, Boolean>,
        BusinessConnectionMethod<UnpinChatMessageMethod, Boolean> {

    private final UnpinChatMessage.UnpinChatMessageBuilder method;

    public UnpinChatMessageMethod() {
        this(UnpinChatMessage.builder());
    }

    public UnpinChatMessageMethod(@NotNull UnpinChatMessage.UnpinChatMessageBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public UnpinChatMessageMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public UnpinChatMessageMethod setMessageId(Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public UnpinChatMessageMethod setBusinessConnectionId(String id) {
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
