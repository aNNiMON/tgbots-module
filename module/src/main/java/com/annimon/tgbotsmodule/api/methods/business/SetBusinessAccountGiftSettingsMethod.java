package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.SetBusinessAccountGiftSettings;
import org.telegram.telegrambots.meta.api.objects.gifts.AcceptedGiftTypes;

public class SetBusinessAccountGiftSettingsMethod implements BusinessConnectionMethod<SetBusinessAccountGiftSettingsMethod, Boolean> {

    private final SetBusinessAccountGiftSettings.SetBusinessAccountGiftSettingsBuilder method;

    public SetBusinessAccountGiftSettingsMethod() {
        this(SetBusinessAccountGiftSettings.builder());
    }

    public SetBusinessAccountGiftSettingsMethod(@NotNull SetBusinessAccountGiftSettings.SetBusinessAccountGiftSettingsBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SetBusinessAccountGiftSettingsMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Boolean getShowGiftButton() {
        return method.build().getShowGiftButton();
    }

    public SetBusinessAccountGiftSettingsMethod setShowGiftButton(Boolean showGiftButton) {
        method.showGiftButton(showGiftButton);
        return this;
    }

    public AcceptedGiftTypes getAcceptedGiftTypes() {
        return method.build().getAcceptedGiftTypes();
    }

    public SetBusinessAccountGiftSettingsMethod setAcceptedGiftTypes(AcceptedGiftTypes acceptedGiftTypes) {
        method.acceptedGiftTypes(acceptedGiftTypes);
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

