package com.annimon.tgbotsmodule.api.methods.stories;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stories.EditStory;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.stories.Story;
import org.telegram.telegrambots.meta.api.objects.stories.StoryArea;
import org.telegram.telegrambots.meta.api.objects.stories.input.InputStoryContent;

public class EditStoryMethod implements
        BusinessConnectionMethod<EditStoryMethod, Story>,
        ParseModeMethod<EditStoryMethod, Story>,
        CaptionMethod<EditStoryMethod, Story> {

    private final EditStory.EditStoryBuilder method;

    public EditStoryMethod() {
        this(EditStory.builder());
    }

    public EditStoryMethod(@NotNull EditStory.EditStoryBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public EditStoryMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Integer getStoryId() {
        return method.build().getStoryId();
    }

    public EditStoryMethod setStoryId(Integer storyId) {
        method.storyId(storyId);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public EditStoryMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public EditStoryMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }

    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public EditStoryMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    public InputStoryContent getContent() {
        return method.build().getContent();
    }

    public EditStoryMethod setContent(InputStoryContent content) {
        method.content(content);
        return this;
    }

    public List<StoryArea> getAreas() {
        return method.build().getAreas();
    }

    public EditStoryMethod setAreas(List<StoryArea> areas) {
        method.areas(areas);
        return this;
    }

    @Override
    public Story call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<Story> callAsync(@NotNull CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
