package com.annimon.tgbotsmodule.commands.context;

import java.util.regex.Matcher;

public class RegexMessageContext extends MessageContext {

    protected final Matcher matcher;

    public RegexMessageContext(MessageContext m, Matcher matcher) {
        super(m.sender, m.update, m.argumentsAsString);
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
