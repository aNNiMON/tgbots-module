package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPermissions;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;

public class SetChatPermissionsMethod implements ChatMethod<SetChatPermissionsMethod, Boolean> {

    private final SetChatPermissions.SetChatPermissionsBuilder method;

    public SetChatPermissionsMethod() {
        this(SetChatPermissions.builder());
    }

    public SetChatPermissionsMethod(@NotNull SetChatPermissions.SetChatPermissionsBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetChatPermissionsMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public ChatPermissions getPermissions() {
        return method.build().getPermissions();
    }

    public SetChatPermissionsMethod setPermissions(@NotNull ChatPermissions permissions) {
        method.permissions(permissions);
        return this;
    }

    public Boolean getUseIndependentChatPermissions() {
        return method.build().getUseIndependentChatPermissions();
    }

    public SetChatPermissionsMethod setUseIndependentChatPermissions(Boolean flag) {
        method.useIndependentChatPermissions(flag);
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
