package com.annimon.tgbotsmodule.api.methods.updates;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updates.GetWebhookInfo;
import org.telegram.telegrambots.meta.api.objects.WebhookInfo;

public class GetWebhookInfoMethod implements Method<WebhookInfo> {

    private final GetWebhookInfo.GetWebhookInfoBuilder method;

    public GetWebhookInfoMethod() {
        this(GetWebhookInfo.builder());
    }

    public GetWebhookInfoMethod(@NotNull GetWebhookInfo.GetWebhookInfoBuilder method) {
        this.method = method;
    }

    @Override
    public WebhookInfo call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<WebhookInfo> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
