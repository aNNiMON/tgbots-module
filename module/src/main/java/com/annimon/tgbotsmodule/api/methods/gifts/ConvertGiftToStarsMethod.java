package com.annimon.tgbotsmodule.api.methods.gifts;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.gifts.ConvertGiftToStars;

public class ConvertGiftToStarsMethod implements BusinessConnectionMethod<ConvertGiftToStarsMethod, Boolean> {

    private final ConvertGiftToStars.ConvertGiftToStarsBuilder<?, ?> method;

    public ConvertGiftToStarsMethod() {
        this(ConvertGiftToStars.builder());
    }

    public ConvertGiftToStarsMethod(@NotNull ConvertGiftToStars.ConvertGiftToStarsBuilder<?, ?> method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public ConvertGiftToStarsMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public String getOwnedGiftId() {
        return method.build().getOwnedGiftId();
    }

    public ConvertGiftToStarsMethod setOwnedGiftId(String ownedGiftId) {
        method.ownedGiftId(ownedGiftId);
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
