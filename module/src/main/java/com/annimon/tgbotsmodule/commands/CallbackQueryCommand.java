package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.context.CallbackQueryContext;

public interface CallbackQueryCommand extends Command<CallbackQueryContext> {

    String command();
}
