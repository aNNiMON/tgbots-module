package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.SetBusinessAccountProfilePhoto;
import org.telegram.telegrambots.meta.api.objects.photo.input.InputProfilePhoto;

public class SetBusinessAccountProfilePhotoMethod implements BusinessConnectionMethod<SetBusinessAccountProfilePhotoMethod, Boolean> {

    private final SetBusinessAccountProfilePhoto.SetBusinessAccountProfilePhotoBuilder method;

    public SetBusinessAccountProfilePhotoMethod() {
        this(SetBusinessAccountProfilePhoto.builder());
    }

    public SetBusinessAccountProfilePhotoMethod(@NotNull SetBusinessAccountProfilePhoto.SetBusinessAccountProfilePhotoBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public SetBusinessAccountProfilePhotoMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public InputProfilePhoto getPhoto() {
        return method.build().getPhoto();
    }

    public SetBusinessAccountProfilePhotoMethod setPhoto(InputProfilePhoto photo) {
        method.photo(photo);
        return this;
    }

    public Boolean getIsPublic() {
        return method.build().getIsPublic();
    }

    public SetBusinessAccountProfilePhotoMethod setIsPublic(Boolean isPublic) {
        method.isPublic(isPublic);
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

