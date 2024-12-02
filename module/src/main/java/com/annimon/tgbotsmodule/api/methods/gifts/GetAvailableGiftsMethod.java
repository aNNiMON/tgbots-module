package com.annimon.tgbotsmodule.api.methods.gifts;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.gifts.GetAvailableGifts;
import org.telegram.telegrambots.meta.api.objects.gifts.Gifts;

public class GetAvailableGiftsMethod implements Method<Gifts> {

    private final GetAvailableGifts.GetAvailableGiftsBuilder method;

    public GetAvailableGiftsMethod() {
        this(GetAvailableGifts.builder());
    }

    public GetAvailableGiftsMethod(@NotNull GetAvailableGifts.GetAvailableGiftsBuilder method) {
        this.method = method;
    }

    @Override
    public Gifts call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Gifts> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
