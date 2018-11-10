package com.annimon.tgbotsmodule.commands.authority;

import org.telegram.telegrambots.meta.api.objects.User;

public interface Authority {

    boolean hasRights(User user, For role);
}
