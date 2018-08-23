package com.annimon.testbot;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class BotConfig {

    @NotBlank
    @JsonProperty(required = true)
    private String token;

    @NotBlank
    @JsonProperty(required = true)
    private String username;

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

    @Override
    public String toString() {
        return "Config{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}