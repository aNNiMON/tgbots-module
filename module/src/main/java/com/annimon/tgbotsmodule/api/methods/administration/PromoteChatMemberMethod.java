package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.PromoteChatMember;

public class PromoteChatMemberMethod implements ChatMemberMethod<PromoteChatMemberMethod, Boolean> {

    private final PromoteChatMember.PromoteChatMemberBuilder method;
    
    public PromoteChatMemberMethod() {
        this(PromoteChatMember.builder());
    }

    public PromoteChatMemberMethod(@NotNull PromoteChatMember.PromoteChatMemberBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public PromoteChatMemberMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public PromoteChatMemberMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public Boolean canChangeInformation() {
        return method.build().getCanChangeInformation();
    }

    public PromoteChatMemberMethod setCanChangeInformation(Boolean canChangeInformation) {
        method.canChangeInformation(canChangeInformation);
        return this;
    }

    public Boolean canPostMessages() {
        return method.build().getCanPostMessages();
    }

    public PromoteChatMemberMethod setCanPostMessages(Boolean canPostMessages) {
        method.canPostMessages(canPostMessages);
        return this;
    }

    public Boolean canEditMessages() {
        return method.build().getCanEditMessages();
    }

    public PromoteChatMemberMethod setCanEditMessages(Boolean canEditMessages) {
        method.canEditMessages(canEditMessages);
        return this;
    }

    public Boolean canDeleteMessages() {
        return method.build().getCanDeleteMessages();
    }

    public PromoteChatMemberMethod setCanDeleteMessages(Boolean canDeleteMessages) {
        method.canDeleteMessages(canDeleteMessages);
        return this;
    }

    public Boolean canInviteUsers() {
        return method.build().getCanInviteUsers();
    }

    public PromoteChatMemberMethod setCanInviteUsers(Boolean canInviteUsers) {
        method.canInviteUsers(canInviteUsers);
        return this;
    }

    public Boolean canRestrictMembers() {
        return method.build().getCanRestrictMembers();
    }

    public PromoteChatMemberMethod setCanRestrictMembers(Boolean canRestrictMembers) {
        method.canRestrictMembers(canRestrictMembers);
        return this;
    }

    public Boolean canPinMessages() {
        return method.build().getCanPinMessages();
    }

    public PromoteChatMemberMethod setCanPinMessages(Boolean canPinMessages) {
        method.canPinMessages(canPinMessages);
        return this;
    }

    public Boolean canPromoteMembers() {
        return method.build().getCanPromoteMembers();
    }

    public PromoteChatMemberMethod setCanPromoteMembers(Boolean canPromoteMembers) {
        method.canPromoteMembers(canPromoteMembers);
        return this;
    }

    public Boolean canManageChat() {
        return method.build().getCanManageChat();
    }

    public PromoteChatMemberMethod setCanManageChat(Boolean canManageChat) {
        method.canManageChat(canManageChat);
        return this;
    }

    public Boolean canManageVideoChats() {
        return method.build().getCanManageVideoChats();
    }

    public PromoteChatMemberMethod setCanManageVideoChats(Boolean canManageVideoChats) {
        method.canManageVideoChats(canManageVideoChats);
        return this;
    }

    public Boolean canManageTopics() {
        return method.build().getCanManageTopics();
    }

    public PromoteChatMemberMethod setCanManageTopics(Boolean canManageTopics) {
        method.canManageTopics(canManageTopics);
        return this;
    }

    public Boolean canPostStories() {
        return method.build().getCanPostStories();
    }

    public PromoteChatMemberMethod setCanPostStories(Boolean canPostStories) {
        method.canPostStories(canPostStories);
        return this;
    }

    public Boolean canEditStories() {
        return method.build().getCanEditStories();
    }

    public PromoteChatMemberMethod setCanEditStories(Boolean canEditStories) {
        method.canEditStories(canEditStories);
        return this;
    }

    public Boolean canDeleteStories() {
        return method.build().getCanDeleteStories();
    }

    public PromoteChatMemberMethod setCanDeleteStories(Boolean canDeleteStories) {
        method.canDeleteStories(canDeleteStories);
        return this;
    }

    public Boolean isAnonymous() {
        return method.build().getIsAnonymous();
    }

    public PromoteChatMemberMethod setIsAnonymous(Boolean isAnonymous) {
        method.isAnonymous(isAnonymous);
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
