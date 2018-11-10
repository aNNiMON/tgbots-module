package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class MessageContextBuilder {
    private CommonAbsSender sender;
    private Update update;
    private User user;
    private Long chatId;
    private String text;

    public MessageContextBuilder setSender(CommonAbsSender sender) {
        this.sender = sender;
        return this;
    }

    public MessageContextBuilder setUpdate(Update update) {
        this.update = update;
        return this;
    }

    public MessageContextBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public MessageContextBuilder setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    public MessageContextBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public MessageContext createContext() {
        return new MessageContext(sender, update, user, chatId, text);
    }
}