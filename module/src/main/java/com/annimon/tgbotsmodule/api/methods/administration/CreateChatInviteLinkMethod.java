package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.CreateChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;

public class CreateChatInviteLinkMethod implements ChatMethod<CreateChatInviteLinkMethod, ChatInviteLink> {

    private final CreateChatInviteLink.CreateChatInviteLinkBuilder method;

    public CreateChatInviteLinkMethod() {
        this(CreateChatInviteLink.builder());
    }

    public CreateChatInviteLinkMethod(@NotNull CreateChatInviteLink.CreateChatInviteLinkBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public CreateChatInviteLinkMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public Integer getExpireDate() {
        return method.build().getExpireDate();
    }

    public CreateChatInviteLinkMethod setExpireDate(Integer expireDate) {
        method.expireDate(expireDate);
        return this;
    }

    public Integer getMemberLimit() {
        return method.build().getMemberLimit();
    }

    public CreateChatInviteLinkMethod setMemberLimit(Integer memberLimit) {
        method.memberLimit(memberLimit);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public CreateChatInviteLinkMethod setName(String name) {
        method.name(name);
        return this;
    }

    public Boolean getCreatesJoinRequest() {
        return method.build().getCreatesJoinRequest();
    }

    public CreateChatInviteLinkMethod setCreatesJoinRequest(Boolean createsJoinRequest) {
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
