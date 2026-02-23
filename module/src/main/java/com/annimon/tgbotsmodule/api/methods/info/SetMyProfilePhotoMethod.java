package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.SetMyProfilePhoto;
import org.telegram.telegrambots.meta.api.objects.photo.input.InputProfilePhoto;

public class SetMyProfilePhotoMethod implements Method<Boolean> {

    private final SetMyProfilePhoto.SetMyProfilePhotoBuilder method;

    public SetMyProfilePhotoMethod() {
        this(SetMyProfilePhoto.builder());
    }

    public SetMyProfilePhotoMethod(@NotNull SetMyProfilePhoto.SetMyProfilePhotoBuilder method) {
        this.method = method;
    }

    public InputProfilePhoto getPhoto() {
        return method.build().getPhoto();
    }

    public SetMyProfilePhotoMethod setPhoto(@NotNull InputProfilePhoto photo) {
        method.photo(photo);
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