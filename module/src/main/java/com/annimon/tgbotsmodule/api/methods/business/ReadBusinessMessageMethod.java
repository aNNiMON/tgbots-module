package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.ReadBusinessMessage;

public class ReadBusinessMessageMethod implements BusinessConnectionMethod<ReadBusinessMessageMethod, Boolean> {

    private final ReadBusinessMessage.ReadBusinessMessageBuilder method;

    public ReadBusinessMessageMethod() {
        this(ReadBusinessMessage.builder());
    }

    public ReadBusinessMessageMethod(@NotNull ReadBusinessMessage.ReadBusinessMessageBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public ReadBusinessMessageMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Long getChatId() {
        return method.build().getChatId();
    }

    public ReadBusinessMessageMethod setChatId(Long chatId) {
        method.chatId(chatId);
        return this;
    }

    public Long getMessageId() {
        return method.build().getMessageId();
    }

    public ReadBusinessMessageMethod setMessageId(Long messageId) {
        method.messageId(messageId);
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

