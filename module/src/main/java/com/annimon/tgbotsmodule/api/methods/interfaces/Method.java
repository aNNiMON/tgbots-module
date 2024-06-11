package com.annimon.tgbotsmodule.api.methods.interfaces;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface Method<T extends Serializable> {

    T call(CommonAbsSender sender);

    CompletableFuture<T> callAsync(CommonAbsSender sender);
}
