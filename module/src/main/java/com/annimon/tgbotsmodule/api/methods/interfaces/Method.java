package com.annimon.tgbotsmodule.api.methods.interfaces;

import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.Serializable;
import java.util.function.Consumer;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface Method<T extends Serializable> {

    T call(CommonAbsSender sender);

    default void callAsync(CommonAbsSender sender) {
        callAsync(sender, null);
    }

    default void callAsync(CommonAbsSender sender,
                           Consumer<? super T> responseConsumer) {
        callAsync(sender, responseConsumer, null);
    }
    
    default void callAsync(CommonAbsSender sender,
                           Consumer<? super T> responseConsumer,
                           Consumer<Exception> exceptionConsumer) {
        callAsync(sender, responseConsumer, sender::handleTelegramApiException, exceptionConsumer);
    }

    void callAsync(CommonAbsSender sender,
                   Consumer<? super T> responseConsumer,
                   Consumer<TelegramApiException> apiExceptionConsumer,
                   Consumer<Exception> exceptionConsumer);
}
