package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface NotificationMethod<M extends Method, T extends Serializable> extends Method<T> {

    boolean isNotificationDisabled();

    default boolean isNotificationEnabled() {
        return !isNotificationDisabled();
    }

    M enableNotification();

    M disableNotification();

    default M setNotificationEnabled(boolean status) {
        if (status) {
            return enableNotification();
        } else {
            return disableNotification();
        }
    }
}