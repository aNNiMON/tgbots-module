package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RevokeChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;

public class RevokeChatInviteLinkMethod implements ChatMethod<RevokeChatInviteLinkMethod, ChatInviteLink> {

    private final RevokeChatInviteLink.RevokeChatInviteLinkBuilder method;

    public RevokeChatInviteLinkMethod() {
        this(RevokeChatInviteLink.builder());
    }

    public RevokeChatInviteLinkMethod(@NotNull RevokeChatInviteLink.RevokeChatInviteLinkBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public RevokeChatInviteLinkMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getInviteLink() {
        return method.build().getInviteLink();
    }

    public RevokeChatInviteLinkMethod setInviteLink(String inviteLink) {
        method.inviteLink(inviteLink);
        return this;
    }

    @Override
    public ChatInviteLink call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ChatInviteLink> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
