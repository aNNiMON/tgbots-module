package com.annimon.tgbotsmodule.commands.context;

import java.util.regex.Matcher;

public class RegexMessageContext extends MessageContext {

    protected final Matcher matcher;

    public RegexMessageContext(MessageContext m, Matcher matcher) {
        super(m.sender, m.update, m.text());
        this.matcher = matcher;
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
