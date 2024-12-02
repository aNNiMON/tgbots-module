package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.SetUserEmojiStatus;

public class SetUserEmojiStatusMethod implements UserMethod<SetUserEmojiStatusMethod, Boolean> {

    private final SetUserEmojiStatus.SetUserEmojiStatusBuilder<?, ?> method;

    public SetUserEmojiStatusMethod() {
        this(SetUserEmojiStatus.builder());
    }

    public SetUserEmojiStatusMethod(@NotNull SetUserEmojiStatus.SetUserEmojiStatusBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public SetUserEmojiStatusMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public String getEmojiStatusCustomEmojiId() {
        return method.build().getEmojiStatusCustomEmojiId();
    }

    public SetUserEmojiStatusMethod setEmojiStatusCustomEmojiId(String emojiStatusCustomEmojiId) {
        method.emojiStatusCustomEmojiId(emojiStatusCustomEmojiId);
        return this;
    }

    public Integer getEmojiStatusExpirationDate() {
        return method.build().getEmojiStatusExpirationDate();
    }

    public SetUserEmojiStatusMethod setEmojiStatusExpirationDate(Integer emojiStatusExpirationDate) {
        method.emojiStatusExpirationDate(emojiStatusExpirationDate);
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
