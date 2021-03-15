package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.context.Context;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public interface Command<T extends Context> {

    <TRole extends Enum<TRole>> EnumSet<TRole> authority();

    void accept(@NotNull T context);
}
