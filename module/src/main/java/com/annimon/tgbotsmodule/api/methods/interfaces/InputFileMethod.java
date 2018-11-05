package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public interface InputFileMethod<M extends Method, T extends Serializable> extends Method<T> {

    InputFile getFile();

    M setFile(String fileId);

    M setFile(File file);

    M setFile(String name, InputStream inputStream);

    M setFile(InputFile file);
}
