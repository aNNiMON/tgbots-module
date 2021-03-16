package com.annimon.tgbotsmodule.commands.context;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.regex.Matcher;
import org.telegram.telegrambots.meta.api.objects.Update;

public class RegexMessageContext extends MessageContext {

    protected final Matcher matcher;

    public RegexMessageContext(CommonAbsSender sender, Update update, String arguments,
                               Matcher matcher) {
        super(sender, update, arguments);
        this.matcher = matcher;
    }

    /**
     * Full text of the message.
     * Can be useful in addition to regex matcher.
     *
     * @return message text
     * @see Context#argumentsAsString()
     */
    @Override
    public String argumentsAsString() {
        return super.argumentsAsString();
    }

    public Matcher matcher() {
        return matcher;
    }

    public String group() {
        return matcher.group();
    }

    public String group(int group) {
        return matcher.group(group);
    }

    public String group(String name) {
        return matcher.group(name);
    }

    public int groupCount() {
        return matcher.groupCount();
    }
}
