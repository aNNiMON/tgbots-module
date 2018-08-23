package com.annimon.tgbotsmodule.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class WebHookConfig {

    @JsonProperty(defaultValue = "false")
    private boolean enabled;

    @Positive
    @JsonProperty(defaultValue = "8443")
    private int port;

    @NotBlank
    @JsonProperty(required = true)
    private String externalUrl;

    @NotBlank
    @JsonProperty(defaultValue = "https://127.0.0.1:$port")
    private String internalUrl;

    @JsonProperty
    private String certificatePublicKeyPath;

    @NotBlank
    @JsonProperty(required = true)
    private String certificateStorePath;

    @NotBlank
    @JsonProperty(required = true)
    private String certificateStorePassword;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getExternalUrl() {
        return externalUrl.replace("$port", Integer.toString(port));
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public String getInternalUrl() {
        return internalUrl.replace("$port", Integer.toString(port));
    }

    public void setInternalUrl(String internalUrl) {
        this.internalUrl = internalUrl;
    }

    public String getCertificatePublicKeyPath() {
        return certificatePublicKeyPath;
    }

    public void setCertificatePublicKeyPath(String certificatePublicKeyPath) {
        this.certificatePublicKeyPath = certificatePublicKeyPath;
    }

    public String getCertificateStorePath() {
        return certificateStorePath;
    }

    public void setCertificateStorePath(String certificateStorePath) {
        this.certificateStorePath = certificateStorePath;
    }

    public String getCertificateStorePassword() {
        return certificateStorePassword;
    }

    public void setCertificateStorePassword(String certificateStorePassword) {
        this.certificateStorePassword = certificateStorePassword;
    }

    @Override
    public String toString() {
        return "WebHookConfig{" +
                "enabled=" + enabled +
                ", port=" + port +
                ", externalUrl='" + externalUrl + '\'' +
                ", internalUrl='" + internalUrl + '\'' +
                ", certificatePublicKeyPath='" + certificatePublicKeyPath + '\'' +
                ", certificateStorePath='" + certificateStorePath + '\'' +
                ", certificateStorePassword='" + certificateStorePassword.replaceAll(".", "x") + '\'' +
                '}';
    }
}