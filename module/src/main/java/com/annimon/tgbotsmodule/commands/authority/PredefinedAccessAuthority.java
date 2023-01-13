package com.annimon.tgbotsmodule.commands.authority;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.LongStream;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

/**
 * Allows access for predefined list of users
 */
public class PredefinedAccessAuthority implements Authority<For> {
    private final Set<Long> allowedUsers;

    public PredefinedAccessAuthority(long userId) {
        this.allowedUsers = new HashSet<>();
        allowedUsers.add(userId);
    }

    public PredefinedAccessAuthority(Collection<Long> allowedUsers) {
        this.allowedUsers = new HashSet<>(allowedUsers);
    }

    public PredefinedAccessAuthority allowAccess(long userId) {
        allowedUsers.add(userId);
        return this;
    }

    public PredefinedAccessAuthority removeAccess(long userId) {
        allowedUsers.remove(userId);
        return this;
    }

    public LongStream allowedUsers() {
        return allowedUsers.stream().mapToLong(Long::longValue);
    }

    @Override
    public boolean hasRights(Update update, @NotNull User user, @NotNull EnumSet<For> roles) {
        return allowedUsers.contains(user.getId());
    }
}
