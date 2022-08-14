package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.api.methods.invoices.SendInvoiceMethod;
import com.annimon.tgbotsmodule.api.methods.other.CopyMessageMethod;
import com.annimon.tgbotsmodule.api.methods.other.ForwardMessageMethod;
import com.annimon.tgbotsmodule.api.methods.send.*;
import com.annimon.tgbotsmodule.api.methods.updatingmessages.DeleteMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MessageContext extends Context {

    private final Long chatId;

    public MessageContext(CommonAbsSender sender, Update update, String arguments) {
        super(sender, update, update.getMessage().getFrom(), arguments);
        this.chatId = update.getMessage().getChatId();
        this.argumentsLimit = 0;
    }

    public @NotNull Message message() {
        return update.getMessage();
    }

    public @NotNull Integer messageId() {
        return message().getMessageId();
    }

    public @NotNull Long chatId() {
        return chatId;
    }

    public @NotNull SendAnimationMethod replyWithAnimation() {
        return Methods.sendAnimation(chatId);
    }

    public @NotNull SendAnimationMethod replyToMessageWithAnimation() {
        return replyWithAnimation()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendAudioMethod replyWithAudio() {
        return Methods.sendAudio(chatId);
    }

    public @NotNull SendAudioMethod replyToMessageWithAudio() {
        return replyWithAudio()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendContactMethod replyWithContact() {
        return Methods.sendContact().setChatId(chatId);
    }

    public @NotNull SendContactMethod replyToMessageWithContact() {
        return replyWithContact()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendDiceMethod replyWithDice() {
        return Methods.sendDice(chatId);
    }

    public @NotNull SendDiceMethod replyToMessageWithDice() {
        return replyWithDice()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendDocumentMethod replyWithDocument() {
        return Methods.sendDocument(chatId);
    }

    public @NotNull SendDocumentMethod replyToMessageWithDocument() {
        return replyWithDocument()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendGameMethod replyWithGame() {
        return Methods.Games.sendGame().setChatId(chatId);
    }

    public @NotNull SendGameMethod replyToMessageWithGame() {
        return replyWithGame()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendInvoiceMethod replyWithInvoice() {
        return Methods.Payments.sendInvoice(chatId);
    }

    public @NotNull SendInvoiceMethod replyToMessageWithInvoice() {
        return replyWithInvoice()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendLocationMethod replyWithLocation() {
        return Methods.sendLocation().setChatId(chatId);
    }

    public @NotNull SendLocationMethod replyToMessageWithLocation() {
        return replyWithLocation()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendMediaGroupMethod replyWithMediaGroup() {
        return Methods.sendMediaGroup().setChatId(chatId);
    }

    public @NotNull SendMediaGroupMethod replyToMessageWithMediaGroup() {
        return replyWithMediaGroup()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendMessageMethod reply() {
        return Methods.sendMessage().setChatId(chatId);
    }

    public @NotNull SendMessageMethod reply(@NotNull String text) {
        return Methods.sendMessage(chatId, text);
    }

    public @NotNull SendMessageMethod replyToMessage() {
        return reply()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendMessageMethod replyToMessage(@NotNull String text) {
        return reply(text)
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendPhotoMethod replyWithPhoto() {
        return Methods.sendPhoto(chatId);
    }

    public @NotNull SendPhotoMethod replyToMessageWithPhoto() {
        return replyWithPhoto()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendStickerMethod replyWithSticker() {
        return Methods.Stickers.sendSticker(chatId);
    }

    public @NotNull SendStickerMethod replyToMessageWithSticker() {
        return replyWithSticker()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendVenueMethod replyWithVenue() {
        return Methods.sendVenue().setChatId(chatId);
    }

    public @NotNull SendVenueMethod replyToMessageWithVenue() {
        return replyWithVenue()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendVideoMethod replyWithVideo() {
        return Methods.sendVideo(chatId);
    }

    public @NotNull SendVideoMethod replyToMessageWithVideo() {
        return replyWithVideo()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendVideoNoteMethod replyWithVideoNote() {
        return Methods.sendVideoNote(chatId);
    }

    public @NotNull SendVideoNoteMethod replyToMessageWithVideoNote() {
        return replyWithVideoNote()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }

    public @NotNull SendVoiceMethod replyWithVoice() {
        return Methods.sendVoice(chatId);
    }

    public @NotNull SendVoiceMethod replyToMessageWithVoice() {
        return replyWithVoice()
                .setReplyToMessageId(messageId())
                .setAllowSendingWithoutReply(true);
    }


    public @NotNull DeleteMessageMethod deleteMessage() {
        return Methods.deleteMessage(chatId, messageId());
    }

    public @NotNull ForwardMessageMethod forwardMessageTo(long toChatId) {
        return Methods.forwardMessage(toChatId, chatId, messageId());
    }

    public @NotNull CopyMessageMethod copyMessageTo(long toChatId) {
        return Methods.copyMessage(toChatId, chatId, messageId());
    }
}
