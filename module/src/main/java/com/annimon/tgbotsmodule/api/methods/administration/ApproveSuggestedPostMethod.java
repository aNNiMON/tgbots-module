package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.suggestedpost.ApproveSuggestedPost;

public class ApproveSuggestedPostMethod implements Method<Boolean> {

    private final ApproveSuggestedPost.ApproveSuggestedPostBuilder<?, ?> method;

    public ApproveSuggestedPostMethod() {
        this(ApproveSuggestedPost.builder());
    }

    public ApproveSuggestedPostMethod(@NotNull ApproveSuggestedPost.ApproveSuggestedPostBuilder<?, ?> method) {
        this.method = method;
    }

    public Integer getChatId() {
        return method.build().getChatId();
    }

    public ApproveSuggestedPostMethod setChatId(Integer chatId) {
        method.chatId(chatId);
        return this;
    }

    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    public ApproveSuggestedPostMethod setMessageId(Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    public Integer getSendDate() {
        return method.build().getSendDate();
    }

    public ApproveSuggestedPostMethod setSendDate(Integer sendDate) {
        method.sendDate(sendDate);
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
