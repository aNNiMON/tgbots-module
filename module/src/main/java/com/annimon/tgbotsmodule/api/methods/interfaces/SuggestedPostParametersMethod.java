package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.suggestedpost.SuggestedPostParameters;

public interface SuggestedPostParametersMethod<M extends Method, T extends Serializable>
        extends ChatMethod<M, T> {

    SuggestedPostParameters getSuggestedPostParameters();

    M setSuggestedPostParameters(SuggestedPostParameters parameters);
}
