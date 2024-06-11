package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.PaginableMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.GetUserProfilePhotos;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;

public class GetUserProfilePhotosMethod implements
        UserMethod<GetUserProfilePhotosMethod, UserProfilePhotos>,
        PaginableMethod<GetUserProfilePhotosMethod, UserProfilePhotos> {

    private final GetUserProfilePhotos.GetUserProfilePhotosBuilder method;

    public GetUserProfilePhotosMethod() {
        this(GetUserProfilePhotos.builder());
    }

    public GetUserProfilePhotosMethod(@NotNull GetUserProfilePhotos.GetUserProfilePhotosBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public GetUserProfilePhotosMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public Integer getOffset() {
        return method.build().getOffset();
    }

    @Override
    public GetUserProfilePhotosMethod setOffset(Integer offset) {
        method.offset(offset);
        return this;
    }

    @Override
    public Integer getLimit() {
        return method.build().getLimit();
    }

    @Override
    public GetUserProfilePhotosMethod setLimit(Integer limit) {
        method.limit(limit);
        return this;
    }

    @Override
    public UserProfilePhotos call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<UserProfilePhotos> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}