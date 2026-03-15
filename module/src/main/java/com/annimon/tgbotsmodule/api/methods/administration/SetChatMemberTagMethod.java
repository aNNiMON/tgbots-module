package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatMemberTag;

public class SetChatMemberTagMethod implements ChatMemberMethod<SetChatMemberTagMethod, Boolean> {

    private final SetChatMemberTag.SetChatMemberTagBuilder<?, ?> method;

    public SetChatMemberTagMethod() {
        this(SetChatMemberTag.builder());
    }

    public SetChatMemberTagMethod(@NotNull SetChatMemberTag.SetChatMemberTagBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetChatMemberTagMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public SetChatMemberTagMethod setUserId(Long userId) {
        method.userId(userId);
        return this;
    }

    public String getTag() {
        return method.build().getTag();
    }

    public SetChatMemberTagMethod setTag(String tag) {
        method.tag(tag);
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
