package com.annimon.tgbotsmodule.commands.authority;

import java.util.EnumSet;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public interface Authority<TRole extends Enum<TRole>> {

    boolean hasRights(Update update, User user, EnumSet<TRole> roles);
}
