package com.annimon.tgbotsmodule.commands;

import org.jetbrains.annotations.NotNull;

public interface CommandBundle<TRole extends Enum<TRole>> {

    void register(@NotNull CommandRegistry<TRole> registry);
}
