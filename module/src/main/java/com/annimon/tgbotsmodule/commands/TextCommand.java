package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.context.MessageContext;
import java.util.Set;

public interface TextCommand<TRole extends Enum<TRole>> extends Command<MessageContext, TRole> {

    String command();

    default Set<String> aliases() {
        return Set.of();
    }
}
