package com.annimon.tgbotsmodule.api.methods.stories;

import com.annimon.tgbotsmodule.api.methods.interfaces.BusinessConnectionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ProtectedContentMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.stories.RepostStory;
import org.telegram.telegrambots.meta.api.objects.stories.Story;

public class RepostStoryMethod implements
        BusinessConnectionMethod<RepostStoryMethod, Story>,
        ProtectedContentMethod<RepostStoryMethod, Story> {

    private final RepostStory.RepostStoryBuilder method;

    public RepostStoryMethod() {
        this(RepostStory.builder());
    }

    public RepostStoryMethod(@NotNull RepostStory.RepostStoryBuilder method) {
        this.method = method;
    }

    @Override
    public String getBusinessConnectionId() {
        return method.build().getBusinessConnectionId();
    }

    @Override
    public RepostStoryMethod setBusinessConnectionId(String id) {
        method.businessConnectionId(id);
        return this;
    }

    public Long getFromChatId() {
        return method.build().getFromChatId();
    }

    public RepostStoryMethod setFromChatId(Long chatId) {
        method.fromChatId(chatId);
        return this;
    }

    public Integer getFromStoryId() {
        return method.build().getFromStoryId();
    }

    public RepostStoryMethod setFromStoryId(Integer storyId) {
        method.fromStoryId(storyId);
        return this;
    }

    @Override
    public Boolean getProtectContent() {
        return method.build().getProtectContent();
    }

    @Override
    public RepostStoryMethod setProtectContent(Boolean protectContent) {
        method.protectContent(protectContent);
        return this;
    }

    public Boolean getPostToChatPage() {
        return method.build().getPostToChatPage();
    }

    public RepostStoryMethod setPostToChatPage(boolean postToChatPage) {
        method.postToChatPage(postToChatPage);
        return this;
    }

    public Integer getActivePeriod() {
        return method.build().getActivePeriod();
    }

    public RepostStoryMethod setActivePeriod(Integer activePeriod) {
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
