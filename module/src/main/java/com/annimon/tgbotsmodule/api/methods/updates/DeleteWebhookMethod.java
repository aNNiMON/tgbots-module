package com.annimon.tgbotsmodule.api.methods.updates;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.updates.DeleteWebhook;

public class DeleteWebhookMethod implements Method<Boolean> {

    private final DeleteWebhook.DeleteWebhookBuilder method;

    public DeleteWebhookMethod() {
        this(DeleteWebhook.builder());
    }

    public DeleteWebhookMethod(@NotNull DeleteWebhook.DeleteWebhookBuilder method) {
        this.method = method;
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
