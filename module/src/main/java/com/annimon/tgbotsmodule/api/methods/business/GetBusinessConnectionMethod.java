package com.annimon.tgbotsmodule.api.methods.business;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.business.GetBusinessConnection;
import org.telegram.telegrambots.meta.api.objects.business.BusinessConnection;

public class GetBusinessConnectionMethod implements BusinessConnectionMethod<GetBusinessConnectionMethod, BusinessConnection> {

    private final GetBusinessConnection.GetBusinessConnectionBuilder method;

    public GetBusinessConnectionMethod() {
        this(GetBusinessConnection.builder());
    }

    public GetBusinessConnectionMethod(@NotNull GetBusinessConnection.GetBusinessConnectionBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public GetBusinessConnectionMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public BusinessConnection call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<BusinessConnection> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
