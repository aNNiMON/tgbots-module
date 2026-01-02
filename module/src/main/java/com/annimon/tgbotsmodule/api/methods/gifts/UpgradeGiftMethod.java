package com.annimon.tgbotsmodule.api.methods.gifts;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.gifts.UpgradeGift;

public class UpgradeGiftMethod implements BusinessConnectionMethod<UpgradeGiftMethod, Boolean> {

    private final UpgradeGift.UpgradeGiftBuilder<?, ?> method;

    public UpgradeGiftMethod() {
        this(UpgradeGift.builder());
    }

    public UpgradeGiftMethod(@NotNull UpgradeGift.UpgradeGiftBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public UpgradeGiftMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public String getOwnedGiftId() {
        return method.build().getOwnedGiftId();
    }

    public UpgradeGiftMethod setOwnedGiftId(String ownedGiftId) {
        method.ownedGiftId(ownedGiftId);
        return this;
    }

    public Boolean getKeepOriginalDetails() {
        return method.build().getKeepOriginalDetails();
    }

    public UpgradeGiftMethod setKeepOriginalDetails(Boolean keepOriginalDetails) {
        method.keepOriginalDetails(keepOriginalDetails);
        return this;
    }

    public Integer getStarCount() {
        return method.build().getStarCount();
    }

    public UpgradeGiftMethod setStarCount(Integer starCount) {
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

