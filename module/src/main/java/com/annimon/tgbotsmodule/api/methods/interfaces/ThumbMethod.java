package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public interface ThumbMethod<M extends Method, T extends Serializable> extends Method<T> {

    InputFile getThumbnail();

    M setThumbnail(InputFile thumb);
}