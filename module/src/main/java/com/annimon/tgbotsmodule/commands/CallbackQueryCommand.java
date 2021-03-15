package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.context.CallbackQueryContext;

public interface CallbackQueryCommand<TRole extends Enum<TRole>> extends Command<CallbackQueryContext, TRole> {

    String command();
}
