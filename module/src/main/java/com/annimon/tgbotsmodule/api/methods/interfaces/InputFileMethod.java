package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public interface InputFileMethod<M extends Method, T extends Serializable> extends Method<T> {

    InputFile getFile();

    default M setFile(String fileId) {
        return setFile(new InputFile(fileId));
    }

    default M setFile(File file) {
        return setFile(new InputFile(file));
    }

    default M setFile(String name, InputStream inputStream) {
        return setFile(new InputFile(inputStream, name));
    }

    M setFile(InputFile file);
}
