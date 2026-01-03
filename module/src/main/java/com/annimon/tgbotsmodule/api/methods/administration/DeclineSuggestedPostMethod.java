package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.suggestedpost.DeclineSuggestedPost;

public class DeclineSuggestedPostMethod implements Method<Boolean> {

    private final DeclineSuggestedPost.DeclineSuggestedPostBuilder<?, ?> method;

    public DeclineSuggestedPostMethod() {
        this(DeclineSuggestedPost.builder());
    }

    public DeclineSuggestedPostMethod(@NotNull DeclineSuggestedPost.DeclineSuggestedPostBuilder<?, ?> method) {
        this.method = method;
    }

    public Integer getChatId() {
        return method.build().getChatId();
    }

    public DeclineSuggestedPostMethod setChatId(Integer chatId) {
        method.chatId(chatId);
        return this;
    }

    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    public DeclineSuggestedPostMethod setMessageId(Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    public String getComment() {
        return method.build().getComment();
    }

    public DeclineSuggestedPostMethod setComment(String comment) {
        method.comment(comment);
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
