package com.annimon.tgbotsmodule.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHookConfig {

    @JsonProperty
    private boolean enabled = false;

    @JsonProperty
    private int port = 8443;

    @JsonProperty(required = true)
    private String externalUrl;

    @JsonProperty
    private String internalUrl = "http://0.0.0.0:$port";

    @JsonProperty
    private String keystorePath;

    @JsonProperty
    private String keystorePassword;

    @JsonProperty
    private String certificatePublicKeyPath;

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

    @NotNull
    public String getExternalUrl() {
        return externalUrl.replace("$port", Integer.toString(port));
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @NotNull
    public String getInternalUrl() {
        return internalUrl.replace("$port", Integer.toString(port));
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

    public String getCertificatePublicKeyPath() {
        return certificatePublicKeyPath;
    }

    public void setCertificatePublicKeyPath(String certificatePublicKeyPath) {
        this.certificatePublicKeyPath = certificatePublicKeyPath;
    }

    @Override
    public String toString() {
        String password = null;
        if (keystorePassword != null) {
            password = "*".repeat(keystorePassword.length());
        }
        return "WebHookConfig{" +
                "enabled=" + enabled +
                ", port=" + port +
                ", externalUrl='" + externalUrl + '\'' +
                ", internalUrl='" + internalUrl + '\'' +
                ", keystorePath='" + keystorePath + '\'' +
                ", keystorePassword='" + password + '\'' +
                ", certificatePublicKeyPath='" + certificatePublicKeyPath + '\'' +
                '}';
    }
}
