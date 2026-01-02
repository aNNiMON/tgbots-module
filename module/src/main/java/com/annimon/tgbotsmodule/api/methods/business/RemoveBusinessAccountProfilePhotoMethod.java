package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.RemoveBusinessAccountProfilePhoto;

public class RemoveBusinessAccountProfilePhotoMethod implements BusinessConnectionMethod<RemoveBusinessAccountProfilePhotoMethod, Boolean> {

    private final RemoveBusinessAccountProfilePhoto.RemoveBusinessAccountProfilePhotoBuilder method;

    public RemoveBusinessAccountProfilePhotoMethod() {
        this(RemoveBusinessAccountProfilePhoto.builder());
    }

    public RemoveBusinessAccountProfilePhotoMethod(@NotNull RemoveBusinessAccountProfilePhoto.RemoveBusinessAccountProfilePhotoBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public RemoveBusinessAccountProfilePhotoMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Boolean getIsPublic() {
        return method.build().getIsPublic();
    }

    public RemoveBusinessAccountProfilePhotoMethod setIsPublic(Boolean isPublic) {
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

