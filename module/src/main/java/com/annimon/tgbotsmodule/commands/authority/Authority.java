package com.annimon.tgbotsmodule.commands.authority;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public interface Authority {

    boolean hasRights(Update update, User user, For role);
}
