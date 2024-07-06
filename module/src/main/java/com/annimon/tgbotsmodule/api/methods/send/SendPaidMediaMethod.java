package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionAboveMediaMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.NotificationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyMarkupSupportedMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ReplyParametersMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.send.SendPaidMedia;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;
import org.telegram.telegrambots.meta.api.objects.media.paid.InputPaidMedia;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SendPaidMediaMethod implements
        ChatMethod<SendPaidMediaMethod, ArrayList<Message>>,
        ProtectedContentMethod<SendPaidMediaMethod, ArrayList<Message>>,
        NotificationMethod<SendPaidMediaMethod, ArrayList<Message>>,
        ParseModeMethod<SendPaidMediaMethod, ArrayList<Message>>,
        ReplyParametersMessageMethod<SendPaidMediaMethod, ArrayList<Message>>,
        ReplyMarkupSupportedMessageMethod<SendPaidMediaMethod, ArrayList<Message>>,
        CaptionMethod<SendPaidMediaMethod, ArrayList<Message>>,
        CaptionAboveMediaMethod<SendPaidMediaMethod, ArrayList<Message>> {

    private final SendPaidMedia.SendPaidMediaBuilder method;

    public SendPaidMediaMethod() {
        this(SendPaidMedia.builder());
    }

    public SendPaidMediaMethod(@NotNull SendPaidMedia.SendPaidMediaBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SendPaidMediaMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public Integer getStarCount() {
        return method.build().getStarCount();
    }

    public SendPaidMediaMethod setStarCount(int starCount) {
        method.starCount(starCount);
        return this;
    }

    public List<InputPaidMedia> getMedia() {
        return method.build().getMedia();
    }

    public SendPaidMediaMethod setMedia(@NotNull List<InputPaidMedia> media) {
        method.media(media);
        return this;
    }

    @Override
    public Integer getMessageThreadId() {
        return 0;
    }

    @Override
    public SendPaidMediaMethod setMessageThreadId(Integer messageThreadId) {
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return 0;
    }

    @Override
    public SendPaidMediaMethod setReplyToMessageId(Integer replyToMessageId) {
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public SendPaidMediaMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public SendPaidMediaMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }

    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public SendPaidMediaMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    @Override
    public Boolean getShowCaptionAboveMedia() {
        return method.build().getShowCaptionAboveMedia();
    }

    @Override
    public SendPaidMediaMethod setShowCaptionAboveMedia(Boolean showCaptionAboveMedia) {
        method.showCaptionAboveMedia(showCaptionAboveMedia);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return Boolean.TRUE.equals(method.build().getDisableNotification());
    }

    @Override
    public SendPaidMediaMethod enableNotification() {
        method.disableNotification(false);
        return this;
    }

    @Override
    public SendPaidMediaMethod disableNotification() {
        method.disableNotification(true);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public SendPaidMediaMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    @Override
    public ReplyParameters getReplyParameters() {
        return method.build().getReplyParameters();
    }

    @Override
    public SendPaidMediaMethod setReplyParameters(@NotNull ReplyParameters replyParameters) {
        method.replyParameters(replyParameters);
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.build().getReplyMarkup();
    }

    @Override
    public SendPaidMediaMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.replyMarkup(replyMarkup);
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

    @Override
    public Boolean getAllowSendingWithoutReply() {
        return null;
    }

    @Override
    public SendPaidMediaMethod setAllowSendingWithoutReply(Boolean allowSendingWithoutReply) {
        return null;
    }
}