package com.annimon.tgbotsmodule.api.methods.updatingmessages;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.checklist.EditMessageChecklist;
import org.telegram.telegrambots.meta.api.objects.checklist.InputChecklist;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class EditMessageChecklistMethod implements
        ChatMessageMethod<EditMessageChecklistMethod, Message>,
        InlineKeyboardMarkupMethod<EditMessageChecklistMethod, Message>,
        BusinessConnectionMethod<EditMessageChecklistMethod, Message> {

    private final EditMessageChecklist.EditMessageChecklistBuilder<?, ?> method;

    public EditMessageChecklistMethod() {
        this(EditMessageChecklist.builder());
    }

    public EditMessageChecklistMethod(@NotNull EditMessageChecklist.EditMessageChecklistBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditMessageChecklistMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public EditMessageChecklistMethod setMessageId(@NotNull Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    @Override
    public InlineKeyboardMarkup getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public EditMessageChecklistMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public EditMessageChecklistMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public InputChecklist getChecklist() {
        return method.build().getChecklist();
    }

    public EditMessageChecklistMethod setChecklist(InputChecklist checklist) {
        method.checklist(checklist);
        return this;
    }

    @Override
    public Message call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Message> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}

