package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.ExportChatInviteLink;

public class ExportChatInviteLinkMethod implements ChatMethod<ExportChatInviteLinkMethod, String> {

    private final ExportChatInviteLink.ExportChatInviteLinkBuilder method;

    public ExportChatInviteLinkMethod() {
        this(ExportChatInviteLink.builder());
    }

    public ExportChatInviteLinkMethod(@NotNull ExportChatInviteLink.ExportChatInviteLinkBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public ExportChatInviteLinkMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public String call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<String> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
