package com.annimon.tgbotsmodule.api.methods.stories;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stories.DeleteStory;

public class DeleteStoryMethod implements BusinessConnectionMethod<DeleteStoryMethod, Boolean> {

    private final DeleteStory.DeleteStoryBuilder method;

    public DeleteStoryMethod() {
        this(DeleteStory.builder());
    }

    public DeleteStoryMethod(@NotNull DeleteStory.DeleteStoryBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public DeleteStoryMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Integer getStoryId() {
        return method.build().getStoryId();
    }

    public DeleteStoryMethod setStoryId(Integer storyId) {
        method.storyId(storyId);
        return this;
    }

    @Override
    public Boolean call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Boolean> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
