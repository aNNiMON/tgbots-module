package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.regex.Matcher;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MessageContextBuilder {
    private CommonAbsSender sender;
    private Update update;
    private String arguments;

    public MessageContextBuilder setSender(CommonAbsSender sender) {
        this.sender = sender;
        return this;
    }

    public MessageContextBuilder setUpdate(Update update) {
        this.update = update;
        return this;
    }

    public MessageContextBuilder setArguments(String arguments) {
        this.arguments = arguments;
        return this;
    }

    public MessageContext createMessageContext() {
        return new MessageContext(sender, update, arguments);
    }

    public RegexMessageContext createRegexContext(Matcher matcher) {
        return new RegexMessageContext(createMessageContext(), matcher);
    }
}