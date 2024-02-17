package com.annimon.tgbotsmodule.api.methods.other;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.reactions.SetMessageReaction;
import org.telegram.telegrambots.meta.api.objects.reactions.ReactionType;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SetMessageReactionMethod implements ChatMessageMethod<SetMessageReactionMethod, Boolean> {

    private final SetMessageReaction method;

    public SetMessageReactionMethod() {
        this(new SetMessageReaction());
    }

    public SetMessageReactionMethod(@NotNull SetMessageReaction method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SetMessageReactionMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getMessageId() {
        return method.getMessageId();
    }

    @Override
    public SetMessageReactionMethod setMessageId(Integer messageId) {
        method.setMessageId(messageId);
        return this;
    }

    public List<ReactionType> getReactionTypes() {
        return method.getReactionTypes();
    }

    public SetMessageReactionMethod setReactionType(ReactionType reactionType) {
        method.setReactionTypes(Collections.singletonList(reactionType));
        return this;
    }

    public SetMessageReactionMethod setReactionTypes(List<ReactionType> reactionTypes) {
        method.setReactionTypes(reactionTypes);
        return this;
    }

    public boolean isBig() {
        return Boolean.TRUE.equals(method.getIsBig());
    }

    public SetMessageReactionMethod setIsBig(boolean isBig) {
        method.setIsBig(isBig);
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
