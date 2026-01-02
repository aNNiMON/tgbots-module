package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.GetBusinessAccountGifts;
import org.telegram.telegrambots.meta.api.objects.gifts.owned.OwnedGifts;

public class GetBusinessAccountGiftsMethod implements BusinessConnectionMethod<GetBusinessAccountGiftsMethod, OwnedGifts> {

    private final GetBusinessAccountGifts.GetBusinessAccountGiftsBuilder method;

    public GetBusinessAccountGiftsMethod() {
        this(GetBusinessAccountGifts.builder());
    }

    public GetBusinessAccountGiftsMethod(@NotNull GetBusinessAccountGifts.GetBusinessAccountGiftsBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public GetBusinessAccountGiftsMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Boolean getExcludeUnsaved() {
        return method.build().getExcludeUnsaved();
    }

    public GetBusinessAccountGiftsMethod setExcludeUnsaved(Boolean excludeUnsaved) {
        method.excludeUnsaved(excludeUnsaved);
        return this;
    }

    public Boolean getExcludeSaved() {
        return method.build().getExcludeSaved();
    }

    public GetBusinessAccountGiftsMethod setExcludeSaved(Boolean excludeSaved) {
        method.excludeSaved(excludeSaved);
        return this;
    }

    public Boolean getExcludeUnlimited() {
        return method.build().getExcludeUnlimited();
    }

    public GetBusinessAccountGiftsMethod setExcludeUnlimited(Boolean excludeUnlimited) {
        method.excludeUnlimited(excludeUnlimited);
        return this;
    }

    public Boolean getExcludeLimited() {
        return method.build().getExcludeLimited();
    }

    public GetBusinessAccountGiftsMethod setExcludeLimited(Boolean excludeLimited) {
        method.excludeLimited(excludeLimited);
        return this;
    }

    public Boolean getExcludeUnique() {
        return method.build().getExcludeUnique();
    }

    public GetBusinessAccountGiftsMethod setExcludeUnique(Boolean excludeUnique) {
        method.excludeUnique(excludeUnique);
        return this;
    }

    public Boolean getSortByPrice() {
        return method.build().getSortByPrice();
    }

    public GetBusinessAccountGiftsMethod setSortByPrice(Boolean sortByPrice) {
        method.sortByPrice(sortByPrice);
        return this;
    }

    public String getOffset() {
        return method.build().getOffset();
    }

    public GetBusinessAccountGiftsMethod setOffset(String offset) {
        method.offset(offset);
        return this;
    }

    public Integer getLimit() {
        return method.build().getLimit();
    }

    public GetBusinessAccountGiftsMethod setLimit(Integer limit) {
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

