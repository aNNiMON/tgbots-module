package com.annimon.tgbotsmodule.api.methods.gifts;

import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.gifts.GetUserGifts;
import org.telegram.telegrambots.meta.api.objects.gifts.owned.OwnedGifts;

public class GetUserGiftsMethod implements UserMethod<GetUserGiftsMethod, OwnedGifts> {

    private final GetUserGifts.GetUserGiftsBuilder method;

    public GetUserGiftsMethod() {
        this(GetUserGifts.builder());
    }

    public GetUserGiftsMethod(@NotNull GetUserGifts.GetUserGiftsBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public GetUserGiftsMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    public Boolean getExcludeUnlimited() {
        return method.build().getExcludeUnlimited();
    }

    public GetUserGiftsMethod setExcludeUnlimited(Boolean excludeUnlimited) {
        method.excludeUnlimited(excludeUnlimited);
        return this;
    }

    public Boolean getExcludeLimitedUpgradable() {
        return method.build().getExcludeLimitedUpgradable();
    }

    public GetUserGiftsMethod setExcludeLimitedUpgradable(Boolean flag) {
        method.excludeLimitedUpgradable(flag);
        return this;
    }

    public Boolean getExcludeLimitedNonUpgradable() {
        return method.build().getExcludeLimitedNonUpgradable();
    }

    public GetUserGiftsMethod setExcludeLimitedNonUpgradable(Boolean flag) {
        method.excludeLimitedNonUpgradable(flag);
        return this;
    }

    public Boolean getExcludeFromBlockchain() {
        return method.build().getExcludeFromBlockchain();
    }

    public GetUserGiftsMethod setExcludeFromBlockchain(Boolean flag) {
        method.excludeFromBlockchain(flag);
        return this;
    }

    public Boolean getExcludeUnique() {
        return method.build().getExcludeUnique();
    }

    public GetUserGiftsMethod setExcludeUnique(Boolean excludeUnique) {
        method.excludeUnique(excludeUnique);
        return this;
    }

    public Boolean getSortByPrice() {
        return method.build().getSortByPrice();
    }

    public GetUserGiftsMethod setSortByPrice(Boolean sortByPrice) {
        method.sortByPrice(sortByPrice);
        return this;
    }

    public String getOffset() {
        return method.build().getOffset();
    }

    public GetUserGiftsMethod setOffset(String offset) {
        method.offset(offset);
        return this;
    }

    public Integer getLimit() {
        return method.build().getLimit();
    }

    public GetUserGiftsMethod setLimit(Integer limit) {
        method.limit(limit);
        return this;
    }

    @Override
    public OwnedGifts call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<OwnedGifts> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
