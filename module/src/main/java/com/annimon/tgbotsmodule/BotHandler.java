package com.annimon.tgbotsmodule;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.logging.BotLogger;
import org.telegram.telegrambots.meta.updateshandlers.SentCallback;
import org.telegram.telegrambots.util.WebhookUtils;

public abstract class BotHandler extends TelegramWebhookBot implements LongPollingBot {

    private static final String LOGTAG = BotHandler.class.getName();

    public BotHandler() {
        this(ApiContext.getInstance(DefaultBotOptions.class));
    }

    public BotHandler(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public void onUpdateReceived(Update update) {
        onUpdate(update);
    }

    @Override
    public BotApiMethod onWebhookUpdateReceived(Update update) {
        return onUpdate(update);
    }

    public abstract BotApiMethod onUpdate(Update update);

    @Override
    public String getBotPath() {
        return getBotUsername();
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException {
        WebhookUtils.clearWebhook(this);
    }

    @Override
    public void onClosing() {
        exe.shutdown();
    }


    public Boolean call(SetChatPhoto setChatPhoto) {
        try {
            return super.execute(setChatPhoto);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return false;
        }
    }

    public List<Message> call(SendMediaGroup sendMediaGroup) {
        try {
            return super.execute(sendMediaGroup);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return Collections.emptyList();
        }
    }

    public Boolean call(AddStickerToSet addStickerToSet) {
        try {
            return super.execute(addStickerToSet);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return false;
        }
    }

    public Boolean call(CreateNewStickerSet createNewStickerSet) {
        try {
            return super.execute(createNewStickerSet);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return false;
        }
    }

    public File call(UploadStickerFile uploadStickerFile) {
        try {
            return super.execute(uploadStickerFile);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public Serializable call(EditMessageMedia editMessageMedia) {
        try {
            return super.execute(editMessageMedia);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public Message call(SendAnimation sendAnimation) {
        try {
            return super.execute(sendAnimation);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public <T extends Serializable, M extends BotApiMethod<T>> T call(M method) {
        try {
            return super.execute(method);
        } catch (TelegramApiException e) {
            handleTelegramApiException(e);
            return null;
        }
    }

    public <T extends Serializable, M extends BotApiMethod<T>,
            C extends SentCallback<T>> void callAsyncWithCallback(M method, C callback) {
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
            M method) {
        this.callAsync(method, null, null);
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
            M method, Consumer<T> responseConsumer) {
        this.callAsync(method, responseConsumer, null);
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
            M method, Consumer<T> responseConsumer,
            Consumer<Exception> exceptionConsumer) {
        this.callAsync(method, responseConsumer,
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
            M method, Consumer<T> responseConsumer,
            Consumer<TelegramApiException> apiExceptionConsumer,
            Consumer<Exception> exceptionConsumer) {
        this.callAsyncWithCallback(method, new SentCallback<>() {
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

    /**
     * Handles exceptions for {@code call} methods.
     *
     * By default logs exception as an error.
     *
     * @param ex  Exception
     */
    protected void handleTelegramApiException(TelegramApiException ex) {
        BotLogger.error(LOGTAG, ex);
    }
}