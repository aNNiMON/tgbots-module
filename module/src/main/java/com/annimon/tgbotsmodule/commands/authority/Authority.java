package com.annimon.tgbotsmodule.commands.authority;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.EnumSet;

public interface Authority<TRole extends Enum<TRole>> {

    boolean hasRights(Update update, User user, EnumSet<TRole> roles);
}
