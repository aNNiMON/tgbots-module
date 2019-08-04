package com.annimon.tgbotsmodule.commands;

import org.jetbrains.annotations.NotNull;

public interface CommandBundle {

    void register(@NotNull CommandRegistry registry);
}
