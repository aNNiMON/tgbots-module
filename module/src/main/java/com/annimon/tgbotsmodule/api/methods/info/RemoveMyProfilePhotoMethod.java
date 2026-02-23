package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.RemoveMyProfilePhoto;

public class RemoveMyProfilePhotoMethod implements Method<Boolean> {

    private final RemoveMyProfilePhoto.RemoveMyProfilePhotoBuilder method;

    public RemoveMyProfilePhotoMethod() {
        this(RemoveMyProfilePhoto.builder());
    }

    public RemoveMyProfilePhotoMethod(@NotNull RemoveMyProfilePhoto.RemoveMyProfilePhotoBuilder method) {
        this.method = method;
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