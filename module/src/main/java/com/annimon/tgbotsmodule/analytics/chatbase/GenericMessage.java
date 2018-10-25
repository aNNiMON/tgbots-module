package com.annimon.tgbotsmodule.analytics.chatbase;

import com.annimon.tgbotsmodule.analytics.Event;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

class GenericMessage {

    @JsonProperty("api_key")
    private String apiKey;

    private String type;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("time_stamp")
    private long timestamp;

    private String platform;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String intent;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("not_handled")
    private boolean notHandled;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String version;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("session_id")
    private String sessionId;

    public GenericMessage() {
    }

    public GenericMessage(String apiKey, String type, Event e) {
        this(apiKey, type, e.getUserId(), e.getTimestamp(), "Telegram", e.getMessage(),
                e.getIntent(), e.isNotHandled(), e.getVersion(), e.getSessionId());
    }

    public GenericMessage(String apiKey, String type, String userId, long timestamp,
                          String platform, String message, String intent,
                          boolean notHandled, String version, String sessionId) {
        this.apiKey = apiKey;
        this.type = type;
        this.userId = userId;
        this.timestamp = timestamp;
        this.platform = platform;
        this.message = message;
        this.intent = intent;
        this.notHandled = notHandled;
        this.version = version;
        this.sessionId = sessionId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public boolean isNotHandled() {
        return notHandled;
    }

    public void setNotHandled(boolean notHandled) {
        this.notHandled = notHandled;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "GenericMessage{" +
                "apiKey='" + apiKey + '\'' +
                ", type='" + type + '\'' +
                ", userId='" + userId + '\'' +
                ", timestamp=" + timestamp +
                ", platform='" + platform + '\'' +
                ", message='" + message + '\'' +
                ", intent='" + intent + '\'' +
                ", notHandled=" + notHandled +
                ", version='" + version + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
