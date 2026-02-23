package com.annimon.tgbotsmodule.api.methods.gifts;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.PaginableStringMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.gifts.GetChatGifts;
import org.telegram.telegrambots.meta.api.objects.gifts.owned.OwnedGifts;

public class GetChatGiftsMethod implements
        ChatMethod<GetChatGiftsMethod, OwnedGifts>,
        PaginableStringMethod<GetChatGiftsMethod, OwnedGifts> {

    private final GetChatGifts.GetChatGiftsBuilder method;

    public GetChatGiftsMethod() {
        this(GetChatGifts.builder());
    }

    public GetChatGiftsMethod(@NotNull GetChatGifts.GetChatGiftsBuilder method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.build().getChatId();
    }

    @Override
    public GetChatGiftsMethod setChatId(@NotNull String chatId) {
        method.chatId(chatId);
        return this;
    }

    public Boolean getExcludeUnsaved() {
        return method.build().getExcludeUnsaved();
    }

    public GetChatGiftsMethod setExcludeUnsaved(Boolean excludeUnsaved) {
        method.excludeUnsaved(excludeUnsaved);
        return this;
    }

    public Boolean getExcludeSaved() {
        return method.build().getExcludeSaved();
    }

    public GetChatGiftsMethod setExcludeSaved(Boolean excludeSaved) {
        method.excludeSaved(excludeSaved);
        return this;
    }

    public Boolean getExcludeUnlimited() {
        return method.build().getExcludeUnlimited();
    }

    public GetChatGiftsMethod setExcludeUnlimited(Boolean excludeUnlimited) {
        method.excludeUnlimited(excludeUnlimited);
        return this;
    }

    public Boolean getExcludeLimitedUpgradable() {
        return method.build().getExcludeLimitedUpgradable();
    }

    public GetChatGiftsMethod setExcludeLimitedUpgradable(Boolean flag) {
        method.excludeLimitedUpgradable(flag);
        return this;
    }

    public Boolean getExcludeLimitedNonUpgradable() {
        return method.build().getExcludeLimitedNonUpgradable();
    }

    public GetChatGiftsMethod setExcludeLimitedNonUpgradable(Boolean flag) {
        method.excludeLimitedNonUpgradable(flag);
        return this;
    }

    public Boolean getExcludeFromBlockchain() {
        return method.build().getExcludeFromBlockchain();
    }

    public GetChatGiftsMethod setExcludeFromBlockchain(Boolean flag) {
        method.excludeFromBlockchain(flag);
        return this;
    }

    public Boolean getExcludeUnique() {
        return method.build().getExcludeUnique();
    }

    public GetChatGiftsMethod setExcludeUnique(Boolean excludeUnique) {
        method.excludeUnique(excludeUnique);
        return this;
    }

    public Boolean getSortByPrice() {
        return method.build().getSortByPrice();
    }

    public GetChatGiftsMethod setSortByPrice(Boolean sortByPrice) {
        method.sortByPrice(sortByPrice);
        return this;
    }

    @Override
    public String getOffset() {
        return method.build().getOffset();
    }

    @Override
    public GetChatGiftsMethod setOffset(String offset) {
        method.offset(offset);
        return this;
    }

    @Override
    public Integer getLimit() {
        return method.build().getLimit();
    }

    @Override
    public GetChatGiftsMethod setLimit(Integer limit) {
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
