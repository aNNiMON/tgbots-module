package com.annimon.tgbotsmodule.api.methods.stories;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stories.PostStory;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.stories.Story;
import org.telegram.telegrambots.meta.api.objects.stories.StoryArea;
import org.telegram.telegrambots.meta.api.objects.stories.input.InputStoryContent;

public class PostStoryMethod implements
        BusinessConnectionMethod<PostStoryMethod, Story>,
        ProtectedContentMethod<PostStoryMethod, Story>,
        ParseModeMethod<PostStoryMethod, Story>,
        CaptionMethod<PostStoryMethod, Story> {

    private final PostStory.PostStoryBuilder method;

    public PostStoryMethod() {
        this(PostStory.builder());
    }

    public PostStoryMethod(@NotNull PostStory.PostStoryBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public PostStoryMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.build().getParseMode();
    }

    @Override
    public PostStoryMethod setParseMode(String parseMode) {
        method.parseMode(parseMode);
        return this;
    }

    @Override
    public List<MessageEntity> getEntities() {
        return method.build().getCaptionEntities();
    }

    @Override
    public PostStoryMethod setEntities(List<MessageEntity> entities) {
        method.captionEntities(entities);
        return this;
    }

    @Override
    public String getCaption() {
        return method.build().getCaption();
    }

    @Override
    public PostStoryMethod setCaption(String caption) {
        method.caption(caption);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public PostStoryMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    public InputStoryContent getContent() {
        return method.build().getContent();
    }

    public PostStoryMethod setContent(InputStoryContent content) {
        method.content(content);
        return this;
    }

    public List<StoryArea> getAreas() {
        return method.build().getAreas();
    }

    public PostStoryMethod setAreas(List<StoryArea> areas) {
        method.areas(areas);
        return this;
    }

    public Boolean getPostToChatPage() {
        return method.build().getPostToChatPage();
    }

    public PostStoryMethod setPostToChatPage(boolean postToChatPage) {
        method.postToChatPage(postToChatPage);
        return this;
    }

    public Integer getActivePeriod() {
        return method.build().getActivePeriod();
    }

    public PostStoryMethod setActivePeriod(Integer activePeriod) {
        method.activePeriod(activePeriod);
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
