package com.annimon.tgbotsmodule.services;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetThumb;
import org.telegram.telegrambots.meta.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.updateshandlers.SentCallback;

@SuppressWarnings("WeakerAccess")
public abstract class CommonAbsSender extends DefaultAbsSender {

    private static final Logger log = LoggerFactory.getLogger(CommonAbsSender.class);
    private final Map<Class<? extends PartialBotApiMethod<?>>,
                      Consumer<? extends PartialBotApiMethod<?>>> preprocessors;

    public CommonAbsSender(@NotNull DefaultBotOptions options, @NotNull String botToken) {
        super(options, botToken);
        preprocessors = new HashMap<>();
    }

    @Nullable
    public Message call(@NotNull SendDocument method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull SendDocument method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendDocument method,
            @Nullable Consumer<? super Message> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendDocument method,
            @Nullable Consumer<? super Message> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendPhoto method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull SendPhoto method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendPhoto method,
            @Nullable Consumer<? super Message> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendPhoto method,
            @Nullable Consumer<? super Message> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendVideo method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull SendVideo method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendVideo method,
            @Nullable Consumer<? super Message> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendVideo method,
            @Nullable Consumer<? super Message> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendVideoNote method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull SendVideoNote method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendVideoNote method,
            @Nullable Consumer<? super Message> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendVideoNote method,
            @Nullable Consumer<? super Message> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendSticker method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull SendSticker method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendSticker method,
            @Nullable Consumer<? super Message> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendSticker method,
            @Nullable Consumer<? super Message> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendAudio method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull SendAudio method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendAudio method,
            @Nullable Consumer<? super Message> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendAudio method,
            @Nullable Consumer<? super Message> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendVoice method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull SendVoice method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendVoice method,
            @Nullable Consumer<? super Message> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendVoice method,
            @Nullable Consumer<? super Message> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    public Boolean call(@NotNull SetChatPhoto method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return false;
        }
    }

    public void callAsync(
            @NotNull SetChatPhoto method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SetChatPhoto method,
            @Nullable Consumer<? super Boolean> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SetChatPhoto method,
            @Nullable Consumer<? super Boolean> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public List<Message> call(@NotNull SendMediaGroup method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return Collections.emptyList();
        }
    }

    public void callAsync(
            @NotNull SendMediaGroup method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendMediaGroup method,
            @Nullable Consumer<? super List<Message>> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendMediaGroup method,
            @Nullable Consumer<? super List<Message>> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        exe.submit(() -> {
            try {
                preprocessMethod(method);
                final List<Message> result = execute(method);
                if (responseConsumer != null) {
                    responseConsumer.accept(result);
                }
            } catch (TelegramApiException e) {
                if (exceptionConsumer != null) {
                    exceptionConsumer.accept(e);
                }
            }
        });
    }

    public Boolean call(@NotNull AddStickerToSet method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return false;
        }
    }

    public void callAsync(
            @NotNull AddStickerToSet method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull AddStickerToSet method,
            @Nullable Consumer<? super Boolean> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull AddStickerToSet method,
            @Nullable Consumer<? super Boolean> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    public Boolean call(@NotNull CreateNewStickerSet method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return false;
        }
    }

    public void callAsync(
            @NotNull CreateNewStickerSet method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull CreateNewStickerSet method,
            @Nullable Consumer<? super Boolean> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull CreateNewStickerSet method,
            @Nullable Consumer<? super Boolean> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public File call(@NotNull UploadStickerFile method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull UploadStickerFile method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull UploadStickerFile method,
            @Nullable Consumer<? super File> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull UploadStickerFile method,
            @Nullable Consumer<? super File> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Serializable call(@NotNull EditMessageMedia method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull EditMessageMedia method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull EditMessageMedia method,
            @Nullable Consumer<? super Serializable> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull EditMessageMedia method,
            @Nullable Consumer<? super Serializable> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendAnimation method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public void callAsync(
            @NotNull SendAnimation method) {
        callAsync(method, null);
    }

    public void callAsync(
            @NotNull SendAnimation method,
            @Nullable Consumer<? super Message> responseConsumer) {
        callAsync(method, responseConsumer, this::handleTelegramApiException);
    }

    public void callAsync(
            @NotNull SendAnimation method,
            @Nullable Consumer<? super Message> responseConsumer,
            @Nullable Consumer<TelegramApiException> exceptionConsumer) {
        callApiMethodAsync(() -> {
            preprocessMethod(method);
            return execute(method);
        }, responseConsumer, exceptionConsumer);
    }

    @Nullable
    public <T extends Serializable, M extends BotApiMethod<T>> T call(
            @NotNull M method) {
        try {
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public <T extends Serializable, M extends BotApiMethod<T>,
            C extends SentCallback<T>> void callAsyncWithCallback(
            @NotNull M method, @NotNull C callback) {
        try {
            executeAsync(method, callback);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
        }
    }

    /**
     * Simple {@code callAsyncWithCallback} implementation on lambda Consumers.
     * <p>
     * Uses {@code handleTelegramApiException} method
     * as {@code TelegramApiException} error callback and
     * suppresses all other callbacks
     *
     * @param method  api method
     * @param <T> the type of the result
     * @param <M> the type of the api method
     * @see #callAsync(BotApiMethod, Consumer, Consumer, Consumer)
     * @see #handleTelegramApiException(TelegramApiException)
     */
    public <T extends Serializable, M extends BotApiMethod<T>> void callAsync(
            @NotNull M method) {
        callAsync(method, null, null);
    }

    /**
     * {@code callAsyncWithCallback} implementation on lambda Consumers.
     *
     * Uses {@code handleTelegramApiException} method
     * as {@code TelegramApiException} error callback and
     * suppresses exception callback
     *
     * @param method  api method
     * @param responseConsumer  response callback
     * @param <T> the type of the result
     * @param <M> the type of the api method
     * @see #callAsync(BotApiMethod, Consumer, Consumer, Consumer)
     * @see #handleTelegramApiException(TelegramApiException)
     */
    public <T extends Serializable, M extends BotApiMethod<T>> void callAsync(
            @NotNull M method,
            @Nullable Consumer<? super T> responseConsumer) {
        callAsync(method, responseConsumer, null);
    }

    /**
     * {@code callAsyncWithCallback} implementation on lambda Consumers.
     *
     * Uses {@code handleTelegramApiException} method
     * as {@code TelegramApiException} error callback
     *
     * @param method  api method
     * @param responseConsumer  response callback
     * @param exceptionConsumer  exception callback
     * @param <T> the type of the result
     * @param <M> the type of the api method
     * @see #callAsync(BotApiMethod, Consumer, Consumer, Consumer)
     * @see #handleTelegramApiException(TelegramApiException)
     */
    public <T extends Serializable, M extends BotApiMethod<T>> void callAsync(
            @NotNull M method,
            @Nullable Consumer<? super T> responseConsumer,
            @Nullable Consumer<Exception> exceptionConsumer) {
        callAsync(method, responseConsumer,
                this::handleTelegramApiException, exceptionConsumer);
    }

    /**
     * {@code callAsyncWithCallback} implementation on lambda Consumers.
     *
     * @param method  api method
     * @param responseConsumer  response callback
     * @param apiExceptionConsumer  {@code TelegramApiException} error callback
     * @param exceptionConsumer  exception callback
     * @param <T> the type of the result
     * @param <M> the type of the api method
     * @see #callAsyncWithCallback(BotApiMethod, SentCallback)
     */
    public <T extends Serializable, M extends BotApiMethod<T>> void callAsync(
            @NotNull M method,
            @Nullable Consumer<? super T> responseConsumer,
            @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
            @Nullable Consumer<Exception> exceptionConsumer) {
        callAsyncWithCallback(method, new SentCallback<>() {
            @Override
            public void onResult(BotApiMethod<T> method, T response) {
                if (responseConsumer != null) {
                    responseConsumer.accept(response);
                }
            }

            @Override
            public void onError(BotApiMethod<T> method,
                                TelegramApiRequestException apiException) {
                if (apiExceptionConsumer != null) {
                    apiExceptionConsumer.accept(apiException);
                }
            }

            @Override
            public void onException(BotApiMethod<T> method, Exception exception) {
                if (exceptionConsumer != null) {
                    exceptionConsumer.accept(exception);
                }
            }
        });
    }

    private <T extends Serializable> void callApiMethodAsync(
            @NotNull ResultSupplier<? extends T> resultSupplier,
            @Nullable Consumer<? super T> responseConsumer,
            @Nullable Consumer<TelegramApiException> apiExceptionConsumer) {
        exe.submit(() -> {
            try {
                final T result = resultSupplier.get();
                if (responseConsumer != null) {
                    responseConsumer.accept(result);
                }
            } catch (TelegramApiException e) {
                if (apiExceptionConsumer != null) {
                    apiExceptionConsumer.accept(e);
                }
            }
        });
    }


    @Override
    public <T extends Serializable, Method extends BotApiMethod<T>> T execute(Method method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    public Boolean execute(SetChatPhoto method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    public List<Message> execute(SendMediaGroup method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    public Boolean execute(AddStickerToSet method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    public Boolean execute(SetStickerSetThumb method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    public Boolean execute(CreateNewStickerSet method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    public File execute(UploadStickerFile method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    public Serializable execute(EditMessageMedia method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    public Message execute(SendAnimation method) throws TelegramApiException {
        preprocessMethod(method);
        return super.execute(method);
    }

    @Override
    protected <T extends Serializable, Method extends BotApiMethod<T>> CompletableFuture<T> sendApiMethodAsync(Method method) {
        preprocessMethod(method);
        return super.sendApiMethodAsync(method);
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendDocument sendDocument) {
        return super.executeAsync(sendDocument);
    }

    @Override
    public <T extends Serializable, Method extends BotApiMethod<T>, Callback extends SentCallback<T>> void executeAsync(Method method, Callback callback) throws TelegramApiException {
        preprocessMethod(method);
        super.executeAsync(method, callback);
    }

    /**
     * Add function which will preprocess the method before sending it to telegram server
     * @param method  the class of the bot method
     * @param preprocessor  preprocessor to execute
     * @param <M>  the type of the api method
     */
    protected <M extends PartialBotApiMethod<?>> void addMethodPreprocessor(
            @NotNull Class<M> method, @NotNull Consumer<M> preprocessor) {
        preprocessors.put(method, preprocessor);
    }

    @SuppressWarnings("unchecked")
    private <M extends PartialBotApiMethod<?>> void preprocessMethod(@NotNull M method) {
        if (!preprocessors.isEmpty()) {
            var preprocessor = preprocessors.get(method.getClass());
            if (preprocessor != null) {
                // We can safely cast here, because early we
                // added Class<M> and its corresponding Consumer<M>
                ((Consumer<M>) preprocessor).accept(method);
            }
        }
    }

    private interface ResultSupplier<T> {
        T get() throws TelegramApiException;
    }

    /**
     * Handles exceptions for {@code call} methods.
     *
     * By default logs exception as an error.
     *
     * @param ex  Exception
     */
    public void handleTelegramApiException(TelegramApiException ex) {
        log.error("telegram api exception ", ex);
    }
}
