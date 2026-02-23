package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.PaginableMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.GetUserProfileAudios;
import org.telegram.telegrambots.meta.api.objects.UserProfileAudios;

public class GetUserProfileAudiosMethod implements
        UserMethod<GetUserProfileAudiosMethod, UserProfileAudios>,
        PaginableMethod<GetUserProfileAudiosMethod, UserProfileAudios> {

    private final GetUserProfileAudios.GetUserProfileAudiosBuilder method;

    public GetUserProfileAudiosMethod() {
        this(GetUserProfileAudios.builder());
    }

    public GetUserProfileAudiosMethod(@NotNull GetUserProfileAudios.GetUserProfileAudiosBuilder method) {
        this.method = method;
    }

    @Override
    public Long getUserId() {
        return method.build().getUserId();
    }

    @Override
    public GetUserProfileAudiosMethod setUserId(@NotNull Long userId) {
        method.userId(userId);
        return this;
    }

    @Override
    public Integer getOffset() {
        return method.build().getOffset();
    }

    @Override
    public GetUserProfileAudiosMethod setOffset(Integer offset) {
        method.offset(offset);
        return this;
    }

    @Override
    public Integer getLimit() {
        return method.build().getLimit();
    }

    @Override
    public GetUserProfileAudiosMethod setLimit(Integer limit) {
        method.limit(limit);
        return this;
    }

    @Override
    public UserProfileAudios call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<UserProfileAudios> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}