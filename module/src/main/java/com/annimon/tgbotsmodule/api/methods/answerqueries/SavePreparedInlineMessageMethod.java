package com.annimon.tgbotsmodule.api.methods.answerqueries;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.message.SavePreparedInlineMessage;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.message.PreparedInlineMessage;

public class SavePreparedInlineMessageMethod implements UserMethod<SavePreparedInlineMessageMethod, PreparedInlineMessage> {

    private final SavePreparedInlineMessage.SavePreparedInlineMessageBuilder<?, ?> method;

    public SavePreparedInlineMessageMethod() {
        this(SavePreparedInlineMessage.builder());
    }

    public SavePreparedInlineMessageMethod(@NotNull SavePreparedInlineMessage.SavePreparedInlineMessageBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public SavePreparedInlineMessageMethod setUserId(Long userId) {
        method.userId(userId);
        return this;
    }

    public InlineQueryResult getResult() {
        return method.build().getResult();
    }

    public SavePreparedInlineMessageMethod setResult(@NotNull InlineQueryResult result) {
        method.result(result);
        return this;
    }

    public Boolean getAllowBotChats() {
        return method.build().getAllowBotChats();
    }

    public SavePreparedInlineMessageMethod setAllowBotChats(Boolean allowBotChats) {
        method.allowBotChats(allowBotChats);
        return this;
    }

    public Boolean getAllowGroupChats() {
        return method.build().getAllowGroupChats();
    }

    public SavePreparedInlineMessageMethod setAllowGroupChats(Boolean allowGroupChats) {
        method.allowGroupChats(allowGroupChats);
        return this;
    }

    public Boolean getAllowChannelChats() {
        return method.build().getAllowChannelChats();
    }

    public SavePreparedInlineMessageMethod setAllowChannelChats(Boolean allowChannelChats) {
        method.allowChannelChats(allowChannelChats);
        return this;
    }

    public Boolean getAllowUserChats() {
        return method.build().getAllowUserChats();
    }

    public SavePreparedInlineMessageMethod setAllowUserChats(Boolean allowUserChats) {
        method.allowUserChats(allowUserChats);
        return this;
    }

    @Override
    public PreparedInlineMessage call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<PreparedInlineMessage> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}