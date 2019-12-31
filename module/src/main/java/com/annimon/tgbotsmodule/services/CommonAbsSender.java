package com.annimon.tgbotsmodule.services;

import com.annimon.tgbotsmodule.BotHandler;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.methods.send.SendVideoNote;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
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

    public CommonAbsSender(DefaultBotOptions options) {
        super(options);
    }

    @Nullable
    public Message call(@NotNull SendDocument action) {
        try {
            return super.execute(action);
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
    public Message call(@NotNull SendPhoto action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendVideo action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendVideoNote action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendSticker action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendAudio action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendVoice action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    public Boolean call(@NotNull SetChatPhoto action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public List<Message> call(@NotNull SendMediaGroup action) {
        try {
            return super.execute(action);
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

    public Boolean call(@NotNull AddStickerToSet action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    public Boolean call(@NotNull CreateNewStickerSet action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public File call(@NotNull UploadStickerFile action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Serializable call(@NotNull EditMessageMedia action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public Message call(@NotNull SendAnimation action) {
        try {
            return super.execute(action);
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
        callApiMethodAsync(() -> execute(method), responseConsumer, exceptionConsumer);
    }

    @Nullable
    public <T extends Serializable, M extends BotApiMethod<T>> T call(
            @NotNull M method) {
        try {
            return super.execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public <T extends Serializable, M extends BotApiMethod<T>,
            C extends SentCallback<T>> void callAsyncWithCallback(
            @NotNull M method, @NotNull C callback) {
        try {
            super.executeAsync(method, callback);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
        }
    }

    /**
     * Simple {@code callAsyncWithCallback} implementation on lambda Consumers.
     *
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
