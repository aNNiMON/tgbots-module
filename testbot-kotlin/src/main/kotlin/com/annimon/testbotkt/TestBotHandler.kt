package com.annimon.testbotkt

import com.annimon.tgbotsmodule.BotHandler
import com.annimon.tgbotsmodule.api.methods.Methods
import com.annimon.tgbotsmodule.commands.CommandRegistry
import com.annimon.tgbotsmodule.commands.SimpleCommand
import com.annimon.tgbotsmodule.commands.authority.For
import com.annimon.tgbotsmodule.commands.authority.SimpleAuthority
import org.telegram.telegrambots.meta.api.methods.ActionType
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Update

class TestBotHandler(private val botConfig: BotConfig) : BotHandler() {
    val authority = SimpleAuthority(this, botConfig.creatorId)
    val commands = CommandRegistry(this, authority)

    init {
        commands.register(SimpleCommand("/action", For.CREATOR) { ctx ->
            if (ctx.argumentsLength() == 1) {
                Methods.sendChatAction(ctx.chatId(), ActionType.get(ctx.argument(0, "typing")))
                        .callAsync(ctx.sender)
            }
        })
        commands.register(SimpleCommand("/reverse", For.ALL) { ctx ->
            ctx.reply(ctx.text().reversed()).callAsync(ctx.sender)
        })
    }

    override fun onUpdate(update: Update): BotApiMethod<*>? {
        if (commands.handleUpdate(update)) {
            return null
        }
        // handle other updates
        return null
    }

    override fun getBotUsername() = botConfig.username

    override fun getBotToken() = botConfig.token
}