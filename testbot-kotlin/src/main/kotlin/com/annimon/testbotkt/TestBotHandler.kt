package com.annimon.testbotkt

import com.annimon.tgbotsmodule.BotHandler
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class TestBotHandler(private val botConfig: BotConfig) : BotHandler() {

    override fun onUpdate(update: Update): BotApiMethod<*>? {
        val message = update.message
        if (update.hasMessage() && message.hasText()) {
            SendMessage()
                    .setChatId(message.chatId)
                    .setText(message.text.reversed())
                    .call(this)
        }
        return null
    }

    override fun getBotUsername() = botConfig.username

    override fun getBotToken() = botConfig.token
}