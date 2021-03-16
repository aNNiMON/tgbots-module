package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.context.InlineQueryContext;

public interface InlineQueryCommand extends Command<InlineQueryContext> {

    String command();
}
