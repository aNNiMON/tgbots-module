package com.annimon.tgbotsmodule.api.methods.info;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.File;

public class GetFileMethod implements Method<File> {

    private final GetFile.GetFileBuilder method;

    public GetFileMethod() {
        this(GetFile.builder());
    }

    public GetFileMethod(@NotNull GetFile.GetFileBuilder method) {
        this.method = method;
    }

    public String getFileId() {
        return method.build().getFileId();
    }

    public GetFileMethod setFileId(@NotNull String fileId) {
        method.fileId(fileId);
        return this;
    }

    @Override
    public File call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<File> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
