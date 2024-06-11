package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.adminrights.SetMyDefaultAdministratorRights;
import org.telegram.telegrambots.meta.api.objects.adminrights.ChatAdministratorRights;

public class SetMyDefaultAdministratorRightsMethod implements Method<Boolean> {

    private final SetMyDefaultAdministratorRights.SetMyDefaultAdministratorRightsBuilder method;

    public SetMyDefaultAdministratorRightsMethod() {
        this(SetMyDefaultAdministratorRights.builder());
    }

    public SetMyDefaultAdministratorRightsMethod(@NotNull SetMyDefaultAdministratorRights.SetMyDefaultAdministratorRightsBuilder method) {
        this.method = method;
    }

    public boolean getForChannels() {
        return Boolean.TRUE.equals(method.build().getForChannels());
    }

    public SetMyDefaultAdministratorRightsMethod setForChannels(boolean forChannels) {
        method.forChannels(forChannels);
        return this;
    }

    public ChatAdministratorRights getRights() {
        return method.build().getRights();
    }

    public SetMyDefaultAdministratorRightsMethod setRights(ChatAdministratorRights rights) {
        method.rights(rights);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}