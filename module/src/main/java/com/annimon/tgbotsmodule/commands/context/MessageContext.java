package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.api.methods.send.*;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class MessageContext extends Context {

    private final Long chatId;
    private final String text;
    private String[] arguments;

    MessageContext(CommonAbsSender sender, Update update, User user, Long chatId, String text) {
        super(sender, update, user);
        this.chatId = chatId;
        this.text = text;
    }

    public @NotNull Message message() {
        return update.getMessage();
    }

    public @NotNull Long chatId() {
        return chatId;
    }

    public @NotNull String text() {
        return text;
    }

    public @NotNull String argument(int index) {
        return argument(index, "");
    }

    public @NotNull String argument(int index, @NotNull String defaultValue) {
        lazyCreateArguments();
        if (index >= 0 && index < arguments.length) {
            return arguments[index];
        }
        return defaultValue;
    }

    public @NotNull String[] arguments() {
        lazyCreateArguments();
        return arguments;
    }

    public int argumentsLength() {
        return arguments().length;
    }

    private void lazyCreateArguments() {
        if (arguments == null) {
            arguments = text.split("\\s+");
        }
    }

    public @NotNull SendAnimationMethod replyWithAnimation() {
        return Methods.sendAnimation(chatId);
    }

    public @NotNull SendAudioMethod replyWithAudio() {
        return Methods.sendAudio(chatId);
    }

    public @NotNull SendContactMethod replyWithContact() {
        return Methods.sendContact().setChatId(chatId);
    }

    public @NotNull SendDocumentMethod replyWithDocument() {
        return Methods.sendDocument(chatId);
    }

    public @NotNull SendLocationMethod replyWithLocation() {
        return Methods.sendLocation().setChatId(chatId);
    }

    public @NotNull SendMediaGroupMethod replyWithMediaGroup() {
        return Methods.sendMediaGroup().setChatId(chatId);
    }

    public @NotNull SendMessageMethod reply() {
        return Methods.sendMessage().setChatId(chatId);
    }

    public @NotNull SendMessageMethod reply(@NotNull String text) {
        return Methods.sendMessage(chatId, text);
    }

    public @NotNull SendDiceMethod replyWithDice() {
        return Methods.sendDice(chatId);
    }

    public @NotNull SendPhotoMethod replyWithPhoto() {
        return Methods.sendPhoto(chatId);
    }

    public @NotNull SendVenueMethod replyWithVenue() {
        return Methods.sendVenue().setChatId(chatId);
    }

    public @NotNull SendVideoMethod replyWithVideo() {
        return Methods.sendVideo(chatId);
    }

    public @NotNull SendVideoNoteMethod replyWithVideoNote() {
        return Methods.sendVideoNote(chatId);
    }

    public @NotNull SendVoiceMethod replyWithVoice() {
        return Methods.sendVoice(chatId);
    }
}
