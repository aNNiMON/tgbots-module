package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.EditChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EditChatInviteLinkMethod implements ChatMethod<EditChatInviteLinkMethod, ChatInviteLink> {

    private final EditChatInviteLink method;

    public EditChatInviteLinkMethod() {
        this(new EditChatInviteLink() {
            @Override
            public String getMethod() { // TODO: remove after fix in parent lib
                return "editChatInviteLink";
            }
        });
    }

    public EditChatInviteLinkMethod(@NotNull EditChatInviteLink method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public EditChatInviteLinkMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public String getInviteLink() {
        return method.getInviteLink();
    }

    public EditChatInviteLinkMethod setInviteLink(String inviteLink) {
        method.setInviteLink(inviteLink);
        return this;
    }

    public Integer getExpireDate() {
        return method.getExpireDate();
    }

    public EditChatInviteLinkMethod setExpireDate(Integer expireDate) {
        method.setExpireDate(expireDate);
        return this;
    }

    public Integer getMemberLimit() {
        return method.getMemberLimit();
    }

    public EditChatInviteLinkMethod setMemberLimit(Integer memberLimit) {
        method.setMemberLimit(memberLimit);
        return this;
    }

    @Override
    public ChatInviteLink call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super ChatInviteLink> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
