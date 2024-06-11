package com.annimon.tgbotsmodule.api.methods.forum;

import com.annimon.tgbotsmodule.api.methods.interfaces.Method;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.forum.GetForumTopicIconStickers;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;

public class GetForumTopicIconStickersMethod implements Method<ArrayList<Sticker>> {

    private final GetForumTopicIconStickers.GetForumTopicIconStickersBuilder method;

    public GetForumTopicIconStickersMethod() {
        this(GetForumTopicIconStickers.builder());
    }

    public GetForumTopicIconStickersMethod(@NotNull GetForumTopicIconStickers.GetForumTopicIconStickersBuilder method) {
        this.method = method;
    }

    @Override
    public ArrayList<Sticker> call(@NotNull CommonAbsSender sender) {
        return sender.call(method.build());
    }

    @Override
    public CompletableFuture<ArrayList<Sticker>> callAsync(CommonAbsSender sender) {
        return sender.callAsync(method.build());
    }
}
