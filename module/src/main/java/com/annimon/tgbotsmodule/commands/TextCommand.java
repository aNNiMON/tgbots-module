package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.context.MessageContext;

public interface TextCommand extends Command<MessageContext> {

    String command();
}
