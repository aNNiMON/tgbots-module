package com.annimon.tgbotsmodule.api.methods.interfaces;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.function.Consumer;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface Method<T extends Serializable> {

    T execute(CommonAbsSender sender);

    default void executeAsync(CommonAbsSender sender) {
        executeAsync(sender, null);
    }

    default void executeAsync(CommonAbsSender sender,
                              Consumer<? super T> responseConsumer) {
        executeAsync(sender, responseConsumer, null);
    }
    
    default void executeAsync(CommonAbsSender sender,
                              Consumer<? super T> responseConsumer,
                              Consumer<Exception> exceptionConsumer) {
        executeAsync(sender, responseConsumer, sender::handleTelegramApiException, exceptionConsumer);
    }

    void executeAsync(CommonAbsSender sender,
                      Consumer<? super T> responseConsumer,
                      Consumer<TelegramApiException> apiExceptionConsumer,
                      Consumer<Exception> exceptionConsumer);
}
