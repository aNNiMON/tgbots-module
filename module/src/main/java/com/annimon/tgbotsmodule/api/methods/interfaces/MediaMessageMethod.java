package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;

public interface MediaMessageMethod<M extends Method, T extends Serializable>
        extends ReplyMarkupSupportedMessageMethod<M, T>, InputFileMethod<M, T>,
                ProtectedContentMethod<M, T>, MessageEffectMethod<M, T>,
                AllowPaidBroadcastMethod<M, T>, BusinessConnectionMethod<M, T>,
                DirectMessageTopicMethod<M, T>, SuggestedPostParametersMethod<M, T> {

}