package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.adminrights.GetMyDefaultAdministratorRights;
import org.telegram.telegrambots.meta.api.objects.adminrights.ChatAdministratorRights;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetMyDefaultAdministratorRightsMethod implements Method<ChatAdministratorRights> {

    private final GetMyDefaultAdministratorRights method;

    public GetMyDefaultAdministratorRightsMethod() {
        this(new GetMyDefaultAdministratorRights());
    }

    public GetMyDefaultAdministratorRightsMethod(@NotNull GetMyDefaultAdministratorRights method) {
        this.method = method;
    }

    public boolean getForChannels() {
        return Boolean.TRUE.equals(method.getForChannels());
    }

    public GetMyDefaultAdministratorRightsMethod setForChannels(boolean forChannels) {
        method.setForChannels(forChannels);
        return this;
    }

    @Override
    public ChatAdministratorRights call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super ChatAdministratorRights> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
