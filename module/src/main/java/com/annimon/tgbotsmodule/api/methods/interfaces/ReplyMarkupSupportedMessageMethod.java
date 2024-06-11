package com.annimon.tgbotsmodule.api.methods.interfaces;

import java.io.Serializable;
import java.util.List;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

public interface ReplyMarkupSupportedMessageMethod<M extends Method, T extends Serializable>
        extends SendableMessageMethod<M, T> {

    ReplyKeyboard getReplyMarkup();

    M setReplyMarkup(ReplyKeyboard replyMarkup);

    default M setInlineKeyboard(List<InlineKeyboardRow> keyboard) {
        return setReplyMarkup(new InlineKeyboardMarkup(keyboard));
    }

    default M setInlineKeyboard(InlineKeyboardButton button) {
        return setSingleRowInlineKeyboard(button);
    }

    default M setSingleRowInlineKeyboard(List<InlineKeyboardButton> row) {
        return setInlineKeyboard(List.of(new InlineKeyboardRow(row)));
    }

    default M setSingleRowInlineKeyboard(InlineKeyboardButton... buttons) {
        return setSingleRowInlineKeyboard(List.of(buttons));
    }

    default M setSingleColumnInlineKeyboard(List<InlineKeyboardButton> column) {
        return setInlineKeyboard(column.stream().map(InlineKeyboardRow::new).toList());
    }

    default M setSingleColumnInlineKeyboard(InlineKeyboardButton... buttons) {
        return setSingleColumnInlineKeyboard(List.of(buttons));
    }

}