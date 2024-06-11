package com.annimon.tgbotsmodule.api.methods.updates;

import com.annimon.tgbotsmodule.api.methods.interfaces.PaginableMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GetUpdatesMethod implements PaginableMethod<GetUpdatesMethod, ArrayList<Update>> {

    private final GetUpdates.GetUpdatesBuilder method;

    public GetUpdatesMethod() {
        this(GetUpdates.builder());
    }

    public GetUpdatesMethod(@NotNull GetUpdates.GetUpdatesBuilder method) {
        this.method = method;
    }

    @Override
    public Integer getOffset() {
        return method.build().getOffset();
    }

    @Override
    public GetUpdatesMethod setOffset(Integer offset) {
        method.offset(offset);
        return this;
    }

    @Override
    public Integer getLimit() {
        return method.build().getLimit();
    }

    @Override
    public GetUpdatesMethod setLimit(Integer limit) {
        method.limit(limit);
        return this;
    }

    public Integer getTimeout() {
        return method.build().getTimeout();
    }

    public GetUpdatesMethod setTimeout(Integer timeout) {
        method.timeout(timeout);
        return this;
    }

    public List<String> getAllowedUpdates() {
        return method.build().getAllowedUpdates();
    }

    public GetUpdatesMethod setAllowedUpdates(List<String> allowedUpdates) {
        method.allowedUpdates(allowedUpdates);
        return this;
    }

    @Override
    public ArrayList<Update> call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ArrayList<Update>> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}