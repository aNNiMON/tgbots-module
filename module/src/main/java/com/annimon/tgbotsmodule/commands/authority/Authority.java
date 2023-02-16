package com.annimon.tgbotsmodule.commands.authority;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.EnumSet;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public interface Authority<TRole extends Enum<TRole>> {

    boolean hasRights(@NotNull CommonAbsSender sender, @NotNull Update update, @NotNull User user, @NotNull EnumSet<TRole> roles);
}
