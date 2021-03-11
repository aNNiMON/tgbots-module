package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RevokeChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.ChatInviteLink;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RevokeChatInviteLinkMethod implements ChatMethod<RevokeChatInviteLinkMethod, ChatInviteLink> {

    private final RevokeChatInviteLink method;

    public RevokeChatInviteLinkMethod() {
        this(new RevokeChatInviteLink() {
            @Override
            public String getMethod() { // TODO: remove after fix in parent lib
                return "revokeChatInviteLink";
            }
        });
    }

    public RevokeChatInviteLinkMethod(@NotNull RevokeChatInviteLink method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public RevokeChatInviteLinkMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    public String getInviteLink() {
        return method.getInviteLink();
    }

    public RevokeChatInviteLinkMethod setInviteLink(String inviteLink) {
        method.setInviteLink(inviteLink);
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
