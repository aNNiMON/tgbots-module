package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.reactions.SetMessageReaction;
import org.telegram.telegrambots.meta.api.objects.reactions.ReactionType;

public class SetMessageReactionMethod implements ChatMessageMethod<SetMessageReactionMethod, Boolean> {

    private final SetMessageReaction.SetMessageReactionBuilder method;

    public SetMessageReactionMethod() {
        this(SetMessageReaction.builder());
    }

    public SetMessageReactionMethod(@NotNull SetMessageReaction.SetMessageReactionBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public SetMessageReactionMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.build().getMessageId();
    }

    @Override
    public SetMessageReactionMethod setMessageId(Integer messageId) {
        method.messageId(messageId);
        return this;
    }

    public List<ReactionType> getReactionTypes() {
        return method.build().getReactionTypes();
    }

    public SetMessageReactionMethod setReactionType(ReactionType reactionType) {
        method.reactionTypes(Collections.singletonList(reactionType));
        return this;
    }

    public SetMessageReactionMethod setReactionTypes(List<ReactionType> reactionTypes) {
        method.reactionTypes(reactionTypes);
        return this;
    }

    public boolean isBig() {
        return Boolean.TRUE.equals(method.build().getIsBig());
    }

    public SetMessageReactionMethod setIsBig(boolean isBig) {
        method.isBig(isBig);
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
