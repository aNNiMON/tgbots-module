package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.EditChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;

public class EditChatInviteLinkMethod implements ChatMethod<EditChatInviteLinkMethod, ChatInviteLink> {

    private final EditChatInviteLink.EditChatInviteLinkBuilder method;

    public EditChatInviteLinkMethod() {
        this(EditChatInviteLink.builder());
    }

    public EditChatInviteLinkMethod(@NotNull EditChatInviteLink.EditChatInviteLinkBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public EditChatInviteLinkMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getInviteLink() {
        return method.build().getInviteLink();
    }

    public EditChatInviteLinkMethod setInviteLink(String inviteLink) {
        method.inviteLink(inviteLink);
        return this;
    }

    public Integer getExpireDate() {
        return method.build().getExpireDate();
    }

    public EditChatInviteLinkMethod setExpireDate(Integer expireDate) {
        method.expireDate(expireDate);
        return this;
    }

    public Integer getMemberLimit() {
        return method.build().getMemberLimit();
    }

    public EditChatInviteLinkMethod setMemberLimit(Integer memberLimit) {
        method.memberLimit(memberLimit);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public EditChatInviteLinkMethod setName(String name) {
        method.name(name);
        return this;
    }

    public Boolean getCreatesJoinRequest() {
        return method.build().getCreatesJoinRequest();
    }

    public EditChatInviteLinkMethod setCreatesJoinRequest(Boolean createsJoinRequest) {
        method.createsJoinRequest(createsJoinRequest);
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
