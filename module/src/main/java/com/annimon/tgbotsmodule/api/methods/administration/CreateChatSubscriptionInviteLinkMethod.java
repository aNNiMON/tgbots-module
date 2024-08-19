package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.CreateChatSubscriptionInviteLink;
import org.telegram.telegrambots.meta.api.methods.groupadministration.CreateChatSubscriptionInviteLink.CreateChatSubscriptionInviteLinkBuilder;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;

public class CreateChatSubscriptionInviteLinkMethod implements ChatMethod<CreateChatSubscriptionInviteLinkMethod, ChatInviteLink> {

    private final CreateChatSubscriptionInviteLinkBuilder method;

    public CreateChatSubscriptionInviteLinkMethod() {
        this(CreateChatSubscriptionInviteLink.builder());
    }

    public CreateChatSubscriptionInviteLinkMethod(@NotNull CreateChatSubscriptionInviteLinkBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public CreateChatSubscriptionInviteLinkMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public String getName() {
        return method.build().getName();
    }

    public CreateChatSubscriptionInviteLinkMethod setName(String name) {
        method.name(name);
        return this;
    }

    public Integer getSubscriptionPeriod() {
        return method.build().getSubscriptionPeriod();
    }

    public CreateChatSubscriptionInviteLinkMethod setSubscriptionPeriod(Integer period) {
        method.subscriptionPeriod(period);
        return this;
    }

    public Integer getSubscriptionPrice() {
        return method.build().getSubscriptionPrice();
    }

    public CreateChatSubscriptionInviteLinkMethod setSubscriptionPrice(Integer memberLimit) {
        method.subscriptionPrice(memberLimit);
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
