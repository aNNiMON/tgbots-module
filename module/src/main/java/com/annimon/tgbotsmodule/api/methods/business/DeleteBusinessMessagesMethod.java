package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.DeleteBusinessMessages;

public class DeleteBusinessMessagesMethod implements BusinessConnectionMethod<DeleteBusinessMessagesMethod, Boolean> {

    private final DeleteBusinessMessages.DeleteBusinessMessagesBuilder method;

    public DeleteBusinessMessagesMethod() {
        this(DeleteBusinessMessages.builder());
    }

    public DeleteBusinessMessagesMethod(@NotNull DeleteBusinessMessages.DeleteBusinessMessagesBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public DeleteBusinessMessagesMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public List<Integer> getMessageIds() {
        return method.build().getMessageIds();
    }

    public DeleteBusinessMessagesMethod setMessageIds(List<Integer> messageIds) {
        method.messageIds(messageIds);
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
