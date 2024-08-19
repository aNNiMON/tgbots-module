package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.EditChatSubscriptionInviteLink;
import org.telegram.telegrambots.meta.api.methods.groupadministration.EditChatSubscriptionInviteLink.EditChatSubscriptionInviteLinkBuilder;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;

public class EditChatSubscriptionInviteLinkMethod implements ChatMethod<EditChatSubscriptionInviteLinkMethod, ChatInviteLink> {

    private final EditChatSubscriptionInviteLinkBuilder method;

    public EditChatSubscriptionInviteLinkMethod() {
        this(EditChatSubscriptionInviteLink.builder());
    }

    public EditChatSubscriptionInviteLinkMethod(@NotNull EditChatSubscriptionInviteLinkBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditChatSubscriptionInviteLinkMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getInviteLink() {
        return method.build().getInviteLink();
    }

    public EditChatSubscriptionInviteLinkMethod setInviteLink(String inviteLink) {
        method.inviteLink(inviteLink);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public EditChatSubscriptionInviteLinkMethod setName(String name) {
        method.name(name);
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
