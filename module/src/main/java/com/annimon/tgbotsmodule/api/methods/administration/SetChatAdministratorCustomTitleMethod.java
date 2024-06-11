package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatAdministratorCustomTitle;

public class SetChatAdministratorCustomTitleMethod implements ChatMemberMethod<SetChatAdministratorCustomTitleMethod, Boolean> {

    private final SetChatAdministratorCustomTitle.SetChatAdministratorCustomTitleBuilder method;

    public SetChatAdministratorCustomTitleMethod() {
        this(SetChatAdministratorCustomTitle.builder());
    }

    public SetChatAdministratorCustomTitleMethod(@NotNull SetChatAdministratorCustomTitle.SetChatAdministratorCustomTitleBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetChatAdministratorCustomTitleMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public SetChatAdministratorCustomTitleMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public String getCustomTitle() {
        return method.build().getCustomTitle();
    }

    public SetChatAdministratorCustomTitleMethod setCustomTitle(String customTitle) {
        method.customTitle(customTitle);
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
