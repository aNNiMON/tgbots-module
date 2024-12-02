package com.annimon.tgbotsmodule.api.methods.gifts;

import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.TextMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.gifts.SendGift;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

public class SendGiftMethod implements
        UserMethod<SendGiftMethod, Boolean>,
        TextMethod<SendGiftMethod, Boolean>,
        ParseModeMethod<SendGiftMethod, Boolean> {

    private final SendGift.SendGiftBuilder<?, ?> method;

    public SendGiftMethod() {
        this(SendGift.builder());
    }

    public SendGiftMethod(@NotNull SendGift.SendGiftBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public SendGiftMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getTextParseMode();
    }

    @Override
    public SendGiftMethod setParseMode(String parseMode) {
        method.textParseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getTextEntities();
    }

    @Override
    public SendGiftMethod setEntities(List<MessageEntity> entities) {
        method.textEntities(entities);
        return this;
    }

    @Override
    public String getText() {
        return method.build().getText();
    }

    @Override
    public SendGiftMethod setText(String text) {
        method.text(text);
        return this;
    }

    public String getGiftId() {
        return method.build().getGiftId();
    }

    public SendGiftMethod setGiftId(String giftId) {
        method.giftId(giftId);
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