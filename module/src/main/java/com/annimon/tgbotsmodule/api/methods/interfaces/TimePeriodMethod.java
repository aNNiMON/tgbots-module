package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import org.jetbrains.annotations.NotNull;

public interface TimePeriodMethod<M extends Method, T extends Serializable> extends ChatMemberMethod<M, T> {

    Integer getUntilDateInSeconds();

    M setUntilDateInSeconds(Integer untilDate);

    default M setUntilDate(@NotNull Instant instant) {
        return setUntilDateInSeconds((int) instant.getEpochSecond());
    }

    default M setUntilDate(@NotNull ZonedDateTime date) {
        return setUntilDate(date.toInstant());
    }

    default M forTimePeriod(@NotNull Duration duration) {
        return setUntilDate(Instant.now().plusSeconds(duration.toSeconds()));
    }
}