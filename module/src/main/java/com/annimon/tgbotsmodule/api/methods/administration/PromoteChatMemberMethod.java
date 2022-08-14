package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.PromoteChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PromoteChatMemberMethod implements ChatMemberMethod<PromoteChatMemberMethod, Boolean> {

    private final PromoteChatMember method;
    
    public PromoteChatMemberMethod() {
        this(new PromoteChatMember());
    }

    public PromoteChatMemberMethod(@NotNull PromoteChatMember method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public PromoteChatMemberMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public PromoteChatMemberMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    public Boolean canChangeInformation() {
        return method.getCanChangeInformation();
    }

    public PromoteChatMemberMethod setCanChangeInformation(Boolean canChangeInformation) {
        method.setCanChangeInformation(canChangeInformation);
        return this;
    }

    public Boolean canPostMessages() {
        return method.getCanPostMessages();
    }

    public PromoteChatMemberMethod setCanPostMessages(Boolean canPostMessages) {
        method.setCanPostMessages(canPostMessages);
        return this;
    }

    public Boolean canEditMessages() {
        return method.getCanEditMessages();
    }

    public PromoteChatMemberMethod setCanEditMessages(Boolean canEditMessages) {
        method.setCanEditMessages(canEditMessages);
        return this;
    }

    public Boolean canDeleteMessages() {
        return method.getCanDeleteMessages();
    }

    public PromoteChatMemberMethod setCanDeleteMessages(Boolean canDeleteMessages) {
        method.setCanDeleteMessages(canDeleteMessages);
        return this;
    }

    public Boolean canInviteUsers() {
        return method.getCanInviteUsers();
    }

    public PromoteChatMemberMethod setCanInviteUsers(Boolean canInviteUsers) {
        method.setCanInviteUsers(canInviteUsers);
        return this;
    }

    public Boolean canRestrictMembers() {
        return method.getCanRestrictMembers();
    }

    public PromoteChatMemberMethod setCanRestrictMembers(Boolean canRestrictMembers) {
        method.setCanRestrictMembers(canRestrictMembers);
        return this;
    }

    public Boolean canPinMessages() {
        return method.getCanPinMessages();
    }

    public PromoteChatMemberMethod setCanPinMessages(Boolean canPinMessages) {
        method.setCanPinMessages(canPinMessages);
        return this;
    }

    public Boolean canPromoteMembers() {
        return method.getCanPromoteMembers();
    }

    public PromoteChatMemberMethod setCanPromoteMembers(Boolean canPromoteMembers) {
        method.setCanPromoteMembers(canPromoteMembers);
        return this;
    }

    public Boolean canManageChat() {
        return method.getCanManageChat();
    }

    public PromoteChatMemberMethod setCanManageChat(Boolean canManageChat) {
        method.setCanManageChat(canManageChat);
        return this;
    }

    public Boolean canManageVideoChats() {
        return method.getCanManageVideoChats();
    }

    public PromoteChatMemberMethod setCanManageVideoChats(Boolean canManageVideoChats) {
        method.setCanManageVideoChats(canManageVideoChats);
        return this;
    }

    public Boolean isAnonymous() {
        return method.getIsAnonymous();
    }

    public PromoteChatMemberMethod setIsAnonymous(Boolean isAnonymous) {
        method.setIsAnonymous(isAnonymous);
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
