package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.context.Context;
import org.jetbrains.annotations.NotNull;

public interface Command<T extends Context> {

    For authority();

    void accept(@NotNull T context);
}
