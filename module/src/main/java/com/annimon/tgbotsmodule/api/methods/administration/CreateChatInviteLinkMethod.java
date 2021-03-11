package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.CreateChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CreateChatInviteLinkMethod implements ChatMethod<CreateChatInviteLinkMethod, ChatInviteLink> {

    private final CreateChatInviteLink method;

    public CreateChatInviteLinkMethod() {
        this(new CreateChatInviteLink());
    }

    public CreateChatInviteLinkMethod(@NotNull CreateChatInviteLink method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public CreateChatInviteLinkMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public Integer getExpireDate() {
        return method.getExpireDate();
    }

    public CreateChatInviteLinkMethod setExpireDate(Integer expireDate) {
        method.setExpireDate(expireDate);
        return this;
    }

    public Integer getMemberLimit() {
        return method.getMemberLimit();
    }

    public CreateChatInviteLinkMethod setMemberLimit(Integer memberLimit) {
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
