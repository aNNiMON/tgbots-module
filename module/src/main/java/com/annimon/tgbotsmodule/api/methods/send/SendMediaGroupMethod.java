package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.AllowPaidBroadcastMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.DirectMessageTopicMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.MessageEffectMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.SendableMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public class SendMediaGroupMethod implements
        SendableMessageMethod<SendMediaGroupMethod, ArrayList<Message>>,
        ProtectedContentMethod<SendMediaGroupMethod, ArrayList<Message>>,
        AllowPaidBroadcastMethod<SendMediaGroupMethod, ArrayList<Message>>,
        MessageEffectMethod<SendMediaGroupMethod, ArrayList<Message>>,
        DirectMessageTopicMethod<SendMediaGroupMethod, ArrayList<Message>>,
        BusinessConnectionMethod<SendMediaGroupMethod, ArrayList<Message>> {

    private final SendMediaGroup.SendMediaGroupBuilder<?, ?> method;

    public SendMediaGroupMethod() {
        this(SendMediaGroup.builder());
    }

    public SendMediaGroupMethod(@NotNull SendMediaGroup.SendMediaGroupBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendMediaGroupMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.build().getReplyToMessageId();
    }

    @Override
    public SendMediaGroupMethod setReplyToMessageId(Integer messageId) {
        method.replyToMessageId(messageId);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return method.build().getMessageThreadId();
    }

    @Override
    public SendMediaGroupMethod setMessageThreadId(Integer messageThreadId) {
        method.messageThreadId(messageThreadId);
        return this;
    }

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return method.build().getAllowSendingWithoutReply();
    }

    @Override
    public SendMediaGroupMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        method.allowSendingWithoutReply(allowSendingWithoutReply);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendMediaGroupMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendMediaGroupMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    public List<InputMedia> getMedias() {
        return method.build().getMedias();
    }

    public SendMediaGroupMethod setMedias(@NotNull List<InputMedia> media) {
        method.medias(media);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendMediaGroupMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendMediaGroupMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public String getMessageEffectId() {
        return method.build().getMessageEffectId();
    }

    @Override
    public SendMediaGroupMethod setMessageEffectId(String messageEffectId) {
        method.messageEffectId(messageEffectId);
        return this;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SendMediaGroupMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public Boolean getAllowPaidBroadcast() {
        return method.build().getAllowPaidBroadcast();
    }

    @Override
    public SendMediaGroupMethod setAllowPaidBroadcast(Boolean flag) {
        method.allowPaidBroadcast(flag);
        return this;
    }

    @Override
    public Integer getDirectMessagesTopicId() {
        return method.build().getDirectMessagesTopicId();
    }

    @Override
    public SendMediaGroupMethod setDirectMessagesTopicId(Integer topicId) {
        method.directMessagesTopicId(topicId);
        return this;
    }

    @Override
    public ArrayList<Message> call(@NotNull CommonAbsSender sender) {
        return listToArrayList(sender.call(method.build()));
    }

    @Override
    public CompletableFuture<ArrayList<Message>> callAsync(CommonAbsSender sender) {
        return sender.callAsync(method.build()).thenApply(this::listToArrayList);
    }

    private ArrayList<Message> listToArrayList(List<Message> messages) {
        if (messages == null) {
            return new ArrayList<>();
        }
        if (messages instanceof ArrayList) {
            return (ArrayList<Message>) messages;
        }
        return new ArrayList<>(messages);
    }
}