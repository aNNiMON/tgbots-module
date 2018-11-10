package com.annimon.tgbotsmodule.commands.authority;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.telegram.telegrambots.meta.api.objects.User;

public class SimpleAuthority implements Authority {

    private final int creatorId;
    private final Set<Integer> botAdmins;

    public SimpleAuthority(int creatorId) {
        this.creatorId = creatorId;
        botAdmins = ConcurrentHashMap.newKeySet();
    }

    public int getCreatorId() {
        return creatorId;
    }

    public Set<Integer> getBotAdmins() {
        return botAdmins;
    }

    public SimpleAuthority add(Integer id) {
        botAdmins.add(id);
        return this;
    }

    @Override
    public boolean hasRights(User user, For role) {
        final var isCreator = (user.getId() == creatorId);
        if (isCreator) {
            return true;
        }

        switch (role) {
            case ALL:
                return true;
            case ADMIN:
                return (botAdmins.contains(user.getId()));
            case CREATOR:
            default:
                return false;
        }
    }
}
