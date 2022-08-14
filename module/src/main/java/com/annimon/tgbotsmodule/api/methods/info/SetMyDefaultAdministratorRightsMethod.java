package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.adminrights.SetMyDefaultAdministratorRights;
import org.telegram.telegrambots.meta.api.objects.adminrights.ChatAdministratorRights;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetMyDefaultAdministratorRightsMethod implements Method<Boolean> {

    private final SetMyDefaultAdministratorRights method;

    public SetMyDefaultAdministratorRightsMethod() {
        this(new SetMyDefaultAdministratorRights());
    }

    public SetMyDefaultAdministratorRightsMethod(@NotNull SetMyDefaultAdministratorRights method) {
        this.method = method;
    }

    public boolean getForChannels() {
        return Boolean.TRUE.equals(method.getForChannels());
    }

    public SetMyDefaultAdministratorRightsMethod setForChannels(boolean forChannels) {
        method.setForChannels(forChannels);
        return this;
    }

    public ChatAdministratorRights getRights() {
        return method.getRights();
    }

    public SetMyDefaultAdministratorRightsMethod setRights(ChatAdministratorRights rights) {
        method.setRights(rights);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super Boolean> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}