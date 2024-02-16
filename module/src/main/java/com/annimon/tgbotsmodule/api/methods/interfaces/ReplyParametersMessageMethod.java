package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.ReplyParameters;

public interface ReplyParametersMessageMethod<M extends Method, T extends Serializable>
        extends ChatMessageThreadMethod<M, T>, NotificationMethod<M, T> {

    ReplyParameters getReplyParameters();

    M setReplyParameters(@NotNull ReplyParameters replyParameters);
}
