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
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.botapimethods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.methods.stickers.ReplaceStickerInSet;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetThumbnail;
import org.telegram.telegrambots.meta.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SuppressWarnings("WeakerAccess")
public abstract class CommonAbsSender extends OkHttpTelegramClient {

    private static final Logger log = LoggerFactory.getLogger(CommonAbsSender.class);
    private final Map<Class<? extends PartialBotApiMethod<?>>,
                      Consumer<? extends PartialBotApiMethod<?>>> preprocessors;

    public CommonAbsSender(@NotNull String botToken) {
        super(botToken);
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

    public CompletableFuture<Message> callAsync(
            @NotNull SendDocument method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Message> callAsync(
            @NotNull SendPhoto method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Message> callAsync(
            @NotNull SendVideo method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Message> callAsync(
            @NotNull SendVideoNote method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Message> callAsync(
            @NotNull SendSticker method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Message> callAsync(
            @NotNull SendAudio method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Message> callAsync(
            @NotNull SendVoice method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Boolean> callAsync(
            @NotNull SetChatPhoto method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<List<Message>> callAsync(
            @NotNull SendMediaGroup method) {
        preprocessMethod(method);
        return executeAsync(method);
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

    public CompletableFuture<Boolean> callAsync(
            @NotNull AddStickerToSet method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Boolean> callAsync(
            @NotNull CreateNewStickerSet method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
    }

    public Boolean call(@NotNull ReplaceStickerInSet method) {
        try {
            preprocessMethod(method);
            return execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return false;
        }
    }

    public CompletableFuture<Boolean> callAsync(
            @NotNull ReplaceStickerInSet method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<File> callAsync(
            @NotNull UploadStickerFile method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Serializable> callAsync(
            @NotNull EditMessageMedia method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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

    public CompletableFuture<Message> callAsync(
            @NotNull SendAnimation method) {
        return callApiMethodAsync(() -> {
            preprocessMethod(method);
            return executeAsync(method);
        });
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
     * @return {@code CompletableFuture} result
     * @see #handleTelegramApiException(TelegramApiException)
     */
    public <T extends Serializable, M extends BotApiMethod<T>> CompletableFuture<T> callAsync(
            @NotNull M method) {
        return callApiMethodAsync(() -> executeAsync(method));
    }
    
    private <T extends Serializable> CompletableFuture<T> callApiMethodAsync(
            @NotNull ResultSupplier<T> resultSupplier) {
        try {
            return resultSupplier.get();
        } catch (TelegramApiException e) {
            return CompletableFuture.failedFuture(e);
        }
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
    public Boolean execute(SetStickerSetThumbnail method) throws TelegramApiException {
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
    public <T extends Serializable, Method extends BotApiMethod<T>> CompletableFuture<T> executeAsync(Method method) throws TelegramApiException {
        preprocessMethod(method);
        return super.executeAsync(method);
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
        CompletableFuture<T> get() throws TelegramApiException;
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
