package com.annimon.tgbotsmodule.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.Valid;

public class Config {

    public static Config defaultConfig() {
        final var config = new Config();
        config.setLogLevel("INFO");
        config.setModules(List.of());
        return config;
    }

    private String profile;

    @JsonProperty(value = "log-level", defaultValue = "INFO")
    private String logLevel;

    @Valid
    @JsonProperty
    private WebHookConfig webhook;

    @JsonProperty
    private List<String> modules;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public boolean isWebHookEnabled() {
        return (webhook != null) && webhook.isEnabled();
    }

    public WebHookConfig getWebhook() {
        return webhook;
    }

    public void setWebhook(WebHookConfig webhook) {
        this.webhook = webhook;
    }

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Config{" +
                "profile='" + profile + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", webhook=" + webhook +
                ", modules=" + modules +
                '}';
    }
}