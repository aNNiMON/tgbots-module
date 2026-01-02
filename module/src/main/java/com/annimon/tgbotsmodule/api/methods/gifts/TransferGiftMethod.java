package com.annimon.tgbotsmodule.api.methods.gifts;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.gifts.TransferGift;

public class TransferGiftMethod implements BusinessConnectionMethod<TransferGiftMethod, Boolean> {

    private final TransferGift.TransferGiftBuilder<?, ?> method;

    public TransferGiftMethod() {
        this(TransferGift.builder());
    }

    public TransferGiftMethod(@NotNull TransferGift.TransferGiftBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public TransferGiftMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public String getOwnedGiftId() {
        return method.build().getOwnedGiftId();
    }

    public TransferGiftMethod setOwnedGiftId(String ownedGiftId) {
        method.ownedGiftId(ownedGiftId);
        return this;
    }

    public Long getNewOwnerChatId() {
        return method.build().getNewOwnerChatId();
    }

    public TransferGiftMethod setNewOwnerChatId(Long newOwnerChatId) {
        method.newOwnerChatId(newOwnerChatId);
        return this;
    }

    public Integer getStarCount() {
        return method.build().getStarCount();
    }

    public TransferGiftMethod setStarCount(Integer starCount) {
        method.starCount(starCount);
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

