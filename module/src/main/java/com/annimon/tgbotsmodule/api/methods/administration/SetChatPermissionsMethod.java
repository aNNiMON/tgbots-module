package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPermissions;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetChatPermissionsMethod implements ChatMethod<SetChatPermissionsMethod, Boolean> {

    private final SetChatPermissions method;

    public SetChatPermissionsMethod() {
        this(new SetChatPermissions());
    }

    public SetChatPermissionsMethod(@NotNull SetChatPermissions method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SetChatPermissionsMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public ChatPermissions getPermissions() {
        return method.getPermissions();
    }

    public SetChatPermissionsMethod setPermissions(@NotNull ChatPermissions permissions) {
        method.setPermissions(permissions);
        return this;
    }

    public Boolean getUseIndependentChatPermissions() {
        return method.getUseIndependentChatPermissions();
    }

    public SetChatPermissionsMethod setUseIndependentChatPermissions(Boolean flag) {
        method.setUseIndependentChatPermissions(flag);
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
