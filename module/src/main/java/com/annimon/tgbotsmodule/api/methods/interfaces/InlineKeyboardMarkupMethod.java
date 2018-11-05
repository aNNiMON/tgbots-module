package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface InlineKeyboardMarkupMethod<M extends Method, T extends Serializable> extends Method<T> {

    InlineKeyboardMarkup getReplyMarkup();

    M setReplyMarkup(InlineKeyboardMarkup replyMarkup);
}