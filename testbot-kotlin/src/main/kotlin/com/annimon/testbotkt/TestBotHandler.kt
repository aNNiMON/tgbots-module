package com.annimon.testbotkt

import com.annimon.tgbotsmodule.BotHandler
import com.annimon.tgbotsmodule.api.methods.Methods
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Update

class TestBotHandler(private val botConfig: BotConfig) : BotHandler() {

    override fun onUpdate(update: Update): BotApiMethod<*>? {
        val message = update.message
        if (update.hasMessage() && message.hasText()) {
            Methods.sendMessage()
                    .setChatId(message.chatId)
                    .setText(message.text.reversed())
                    .call(this)
        }
        return null
    }

    override fun getBotUsername() = botConfig.username

    override fun getBotToken() = botConfig.token
}