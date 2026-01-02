package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MessageEffectMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyParametersMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.checklist.SendChecklist;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.checklist.InputChecklist;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class SendChecklistMethod implements
        ChatMethod<SendChecklistMethod, Message>,
        ReplyParametersMessageMethod<SendChecklistMethod, Message>,
        InlineKeyboardMarkupMethod<SendChecklistMethod, Message>,
        ProtectedContentMethod<SendChecklistMethod, Message>,
        MessageEffectMethod<SendChecklistMethod, Message>,
        BusinessConnectionMethod<SendChecklistMethod, Message> {

    private final SendChecklist.SendChecklistBuilder<?, ?> method;

    public SendChecklistMethod() {
        this(SendChecklist.builder());
    }

    public SendChecklistMethod(@NotNull SendChecklist.SendChecklistBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendChecklistMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return null;
    }

    @Override
    public SendChecklistMethod setMessageThreadId(Integer messageThreadId) {
        return null;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendChecklistMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendChecklistMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendChecklistMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public InlineKeyboardMarkup getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendChecklistMethod setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        method.replyMarkup(replyMarkup);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendChecklistMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendChecklistMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendChecklistMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public InputChecklist getChecklist() {
        return method.build().getChecklist();
    }

    public SendChecklistMethod setChecklist(InputChecklist checklist) {
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
