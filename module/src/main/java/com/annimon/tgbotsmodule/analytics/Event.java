package com.annimon.tgbotsmodule.analytics;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.User;

public class Event {

    public static Event withUser(@NotNull User user) {
        return withUser(Integer.toString(user.getId(), 10));
    }

    public static Event withUser(@NotNull String userId) {
        return new Event(userId);
    }

    private final String userId;
    private LocalDateTime dateTime;
    private String message;
    private String intent;
    private boolean notHandled;
    private String version;
    private String sessionId;

    private Event(String userId) {
        this.userId = userId;
        dateTime = timestampToLocalDateTime(System.currentTimeMillis());
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @NotNull
    public Event setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public long getTimestamp() {
        return dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    @NotNull
    public Event setTimestamp(long timestamp) {
        this.dateTime = timestampToLocalDateTime(timestamp);
        return this;
    }

    private LocalDateTime timestampToLocalDateTime(long timestamp) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timestamp),
                ZoneOffset.UTC);
    }

    public String getMessage() {
        return message;
    }

    @NotNull
    public Event setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getIntent() {
        return intent;
    }

    @NotNull
    public Event setIntent(String intent) {
        this.intent = intent;
        return this;
    }

    public boolean isNotHandled() {
        return notHandled;
    }

    @NotNull
    public Event setNotHandled(boolean notHandled) {
        this.notHandled = notHandled;
        return this;
    }

    public String getVersion() {
        return version;
    }

    @NotNull
    public Event setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    @NotNull
    public Event setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return notHandled == event.notHandled &&
                Objects.equals(userId, event.userId) &&
                Objects.equals(dateTime, event.dateTime) &&
                Objects.equals(message, event.message) &&
                Objects.equals(intent, event.intent) &&
                Objects.equals(version, event.version) &&
                Objects.equals(sessionId, event.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, dateTime, message, intent, notHandled, version, sessionId);
    }

    @Override
    public String toString() {
        return "Event{" +
                "userId='" + userId + '\'' +
                ", dateTime=" + dateTime +
                ", message='" + message + '\'' +
                ", intent='" + intent + '\'' +
                ", notHandled=" + notHandled +
                ", version='" + version + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
