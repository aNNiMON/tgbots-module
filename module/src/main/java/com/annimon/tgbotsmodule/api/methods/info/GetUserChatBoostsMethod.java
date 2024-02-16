package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMemberMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.boosts.GetUserChatBoosts;
import org.telegram.telegrambots.meta.api.objects.boost.UserChatBoosts;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetUserChatBoostsMethod implements ChatMemberMethod<GetUserChatBoostsMethod, UserChatBoosts> {

    private final GetUserChatBoosts method;

    public GetUserChatBoostsMethod() {
        this(new GetUserChatBoosts());
    }

    public GetUserChatBoostsMethod(@NotNull GetUserChatBoosts method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public GetUserChatBoostsMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Long getUserId() {
        return method.getUserId();
    }

    @Override
    public GetUserChatBoostsMethod setUserId(@NotNull Long userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public UserChatBoosts call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super UserChatBoosts> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
