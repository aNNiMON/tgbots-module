package com.annimon.tgbotsmodule.services;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleLocalizationService implements LocalizationService {

    private final String resourceName;
    private final Map<String, ResourceBundle> bundles;
    private final ResourceBundle defaultBundle;

    public ResourceBundleLocalizationService(String resourceName) {
        this.resourceName = resourceName;
        bundles = new HashMap<>();
        defaultBundle = ResourceBundle.getBundle(resourceName, Locale.ROOT);
        bundles.put("en", defaultBundle);
    }

    @Override
    public String getString(String key, String language) {
        final var bundle = lazyLoadLanguage(language);
        return bundle.getString(key);
    }

    private ResourceBundle lazyLoadLanguage(String language) {
        if (bundles.containsKey(language)) {
            return bundles.get(language);
        }
        try {
            final var bundle = ResourceBundle.getBundle(resourceName, new Locale(language));
            bundles.put(language, bundle);
            return bundle;
        } catch (MissingResourceException mre) {
            return defaultBundle;
        }
    }
}
