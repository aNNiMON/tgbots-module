package com.annimon.tgbotsmodule.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;

public class WebHookConfig {

    @JsonProperty(defaultValue = "false")
    private boolean enabled = false;

    @NotBlank
    @JsonProperty(defaultValue = "https://127.0.0.1:$port")
    private String internalUrl;

    @JsonProperty
    private String keystorePath;

    @JsonProperty
    private String keystorePassword;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @NotNull
    public String getInternalUrl() {
        return internalUrl;
    }

    public void setInternalUrl(String internalUrl) {
        this.internalUrl = internalUrl;
    }

    public String getKeystorePath() {
        return keystorePath;
    }

    public void setKeystorePath(String path) {
        this.keystorePath = path;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    @Override
    public String toString() {
        return "WebHookConfig{" +
                "enabled=" + enabled +
                ", internalUrl='" + internalUrl + '\'' +
                ", keystorePath='" + keystorePath + '\'' +
                ", keystorePassword='" + keystorePassword.replaceAll(".", "x") + '\'' +
                '}';
    }
}