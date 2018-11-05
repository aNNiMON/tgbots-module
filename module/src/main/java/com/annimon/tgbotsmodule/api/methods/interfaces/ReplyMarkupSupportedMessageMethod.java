package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface ReplyMarkupSupportedMessageMethod<M extends Method, T extends Serializable>
        extends SendableMessageMethod<M, T> {

    ReplyKeyboard getReplyMarkup();

    M setReplyMarkup(ReplyKeyboard replyMarkup);
}