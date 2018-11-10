package com.annimon.tgbotsmodule.api.methods.updates;

import com.annimon.tgbotsmodule.api.methods.interfaces.PaginableMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetUpdatesMethod implements PaginableMethod<GetUpdatesMethod, ArrayList<Update>> {

    private final GetUpdates method;

    public GetUpdatesMethod() {
        this(new GetUpdates());
    }

    public GetUpdatesMethod(@NotNull GetUpdates method) {
        this.method = method;
    }

    @Override
    public Integer getOffset() {
        return method.getOffset();
    }

    @Override
    public GetUpdatesMethod setOffset(Integer offset) {
        method.setOffset(offset);
        return this;
    }

    @Override
    public Integer getLimit() {
        return method.getLimit();
    }

    @Override
    public GetUpdatesMethod setLimit(Integer limit) {
        method.setLimit(limit);
        return this;
    }

    public Integer getTimeout() {
        return method.getTimeout();
    }

    public GetUpdatesMethod setTimeout(Integer timeout) {
        method.setTimeout(timeout);
        return this;
    }

    public List<String> getAllowedUpdates() {
        return method.getAllowedUpdates();
    }

    public GetUpdatesMethod setAllowedUpdates(List<String> allowedUpdates) {
        method.setAllowedUpdates(allowedUpdates);
        return this;
    }

    @Override
    public ArrayList<Update> call(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void callAsync(@NotNull CommonAbsSender sender,
                          @Nullable Consumer<? super ArrayList<Update>> responseConsumer,
                          @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                          @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}