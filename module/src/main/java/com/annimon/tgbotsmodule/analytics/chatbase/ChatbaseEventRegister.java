package com.annimon.tgbotsmodule.analytics.chatbase;

import com.annimon.tgbotsmodule.analytics.Event;
import com.annimon.tgbotsmodule.analytics.EventRegister;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.logging.BotLogger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ChatbaseEventRegister implements Callback<GenericResponse>, EventRegister {

    private static final String LOGTAG = ChatbaseEventRegister.class.getName();

    private final String apiKey;
    private final String version;
    private final ChatbaseApi api;

    public ChatbaseEventRegister(@NotNull String apiKey) {
        this(apiKey, null);
    }

    public ChatbaseEventRegister(@NotNull String apiKey, @Nullable String version) {
        this.apiKey = apiKey;
        this.version = version;

        final var retrofit = new Retrofit.Builder()
                .baseUrl(ChatbaseApi.API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        api = retrofit.create(ChatbaseApi.class);
    }

    @Override
    public void received(@Nullable Event event) {
        registerEvent(event, "withUser");
    }

    @Override
    public void sent(@Nullable Event event) {
        registerEvent(event, "agent");
    }

    private void registerEvent(@Nullable Event event, @NotNull String type) {
        if (event == null) {
            throw new IllegalArgumentException("event must be non null");
        }

        final Predicate<String> nullOrEmpty = s -> (s == null) || (s.isEmpty());
        if (nullOrEmpty.test(event.getVersion()) && !nullOrEmpty.test(version)) {
            event.setVersion(version);
        }

        final var body = new GenericMessage(apiKey, type, event);
        api.message(body).enqueue(this);
    }

    @Override
    public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
    }

    @Override
    public void onFailure(Call<GenericResponse> call, Throwable t) {
        BotLogger.error(LOGTAG, t);
    }
}
