package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.PaginableMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.UserMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.GetUserProfilePhotos;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetUserProfilePhotosMethod implements
        UserMethod<GetUserProfilePhotosMethod, UserProfilePhotos>,
        PaginableMethod<GetUserProfilePhotosMethod, UserProfilePhotos> {

    private final GetUserProfilePhotos method;

    public GetUserProfilePhotosMethod() {
        this(new GetUserProfilePhotos());
    }

    public GetUserProfilePhotosMethod(@NotNull GetUserProfilePhotos method) {
        this.method = method;
    }

    @Override
    public Integer getUserId() {
        return method.getUserId();
    }

    @Override
    public GetUserProfilePhotosMethod setUserId(@NotNull Integer userId) {
        method.setUserId(userId);
        return this;
    }

    @Override
    public Integer getOffset() {
        return method.getOffset();
    }

    @Override
    public GetUserProfilePhotosMethod setOffset(@NotNull Integer offset) {
        method.setOffset(offset);
        return this;
    }

    @Override
    public Integer getLimit() {
        return method.getLimit();
    }

    @Override
    public GetUserProfilePhotosMethod setLimit(Integer limit) {
        method.setLimit(limit);
        return this;
    }

    @Override
    public UserProfilePhotos execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super UserProfilePhotos> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}