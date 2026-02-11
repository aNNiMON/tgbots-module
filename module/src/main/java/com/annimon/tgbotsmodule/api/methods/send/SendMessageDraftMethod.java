package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.*;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendMessageDraft;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

public class SendMessageDraftMethod implements
        ChatMessageThreadMethod<SendMessageDraftMethod, Boolean>,
        ParseModeMethod<SendMessageDraftMethod, Boolean>,
        TextMethod<SendMessageDraftMethod, Boolean> {

    private final SendMessageDraft.SendMessageDraftBuilder<?, ?> method;

    public SendMessageDraftMethod() {
        this(SendMessageDraft.builder());
    }

    public SendMessageDraftMethod(@NotNull SendMessageDraft.SendMessageDraftBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return Long.toString(method.build().getChatId());
    }

    @Override
    public SendMessageDraftMethod setChatId(@NotNull String chatId) {
        method.chatId(Long.parseLong(chatId));
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendMessageDraftMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    public Integer getDraftId() {
        return method.build().getDraftId();
    }

    public SendMessageDraftMethod setDraftId(Integer draftId) {
        method.draftId(draftId);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public SendMessageDraftMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getEntities();
    }

    @Override
    public SendMessageDraftMethod setEntities(List<MessageEntity> entities) {
        method.build().setEntities(entities);
        return this;
    }

    @Override
    public String getText() {
        return method.build().getText();
    }

    @Override
    public SendMessageDraftMethod setText(@NotNull String text) {
        method.text(text);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}