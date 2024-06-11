package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.adminrights.GetMyDefaultAdministratorRights;
import org.telegram.telegrambots.meta.api.objects.adminrights.ChatAdministratorRights;

public class GetMyDefaultAdministratorRightsMethod implements Method<ChatAdministratorRights> {

    private final GetMyDefaultAdministratorRights.GetMyDefaultAdministratorRightsBuilder method;

    public GetMyDefaultAdministratorRightsMethod() {
        this(GetMyDefaultAdministratorRights.builder());
    }

    public GetMyDefaultAdministratorRightsMethod(@NotNull GetMyDefaultAdministratorRights.GetMyDefaultAdministratorRightsBuilder method) {
        this.method = method;
    }

    public boolean getForChannels() {
        return Boolean.TRUE.equals(method.build().getForChannels());
    }

    public GetMyDefaultAdministratorRightsMethod setForChannels(boolean forChannels) {
        method.forChannels(forChannels);
        return this;
    }

    @Override
    public ChatAdministratorRights call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ChatAdministratorRights> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
