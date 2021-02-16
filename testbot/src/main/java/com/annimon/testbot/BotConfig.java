package com.annimon.testbot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BotConfig {

    @JsonProperty(required = true)
    private String token;

    @JsonProperty(required = true)
    private String username;

    @JsonProperty(required = true)
    private Integer creatorId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public String toString() {
        return "BotConfig{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", creatorId=" + creatorId +
                '}';
    }
}