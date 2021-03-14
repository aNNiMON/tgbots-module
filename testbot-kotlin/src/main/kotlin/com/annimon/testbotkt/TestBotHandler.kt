package com.annimon.testbotkt

import com.annimon.testbotkt.commands.LocalizationBundle
import com.annimon.tgbotsmodule.BotHandler
import com.annimon.tgbotsmodule.api.methods.Methods
import com.annimon.tgbotsmodule.commands.CommandRegistry
import com.annimon.tgbotsmodule.commands.SimpleCommand
import com.annimon.tgbotsmodule.commands.authority.For
import com.annimon.tgbotsmodule.commands.authority.SimpleAuthority
import org.telegram.telegrambots.meta.api.methods.ActionType
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText
import org.telegram.telegrambots.meta.api.objects.Update

class TestBotHandler(private val botConfig: BotConfig) : BotHandler() {
    private val authority = SimpleAuthority(this, botConfig.creatorId)
    private val commands = CommandRegistry(this, authority)

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

        // Polls
        commands.register(SimpleCommand("/poll", For.ALL) { ctx ->
            val lines = ctx.text().lines().filterNot { it.isBlank() }
            if (lines.size <= 3) {
                ctx.reply("At least 3 lines expected").callAsync(ctx.sender)
            } else {
                Methods.Polls.sendPoll(ctx.chatId())
                        .setQuestion(lines[0])
                        .setOptions(lines.drop(1))
                        .callAsync(ctx.sender)
            }
        })
        commands.register(SimpleCommand("/stoppoll", For.ALL) { ctx ->
            if (!ctx.message().isReply) {
                ctx.reply("reply with this command to a poll message").callAsync(ctx.sender)
            } else {
                Methods.Polls.stopPoll(ctx.chatId(), ctx.message().replyToMessage.messageId)
                        .callAsync(ctx.sender)
            }
        })

        // Locale
        commands.registerBundle(LocalizationBundle())

        addMethodPreprocessor(SendMessage.PATH){
            it as SendMessage
            it.disableWebPagePreview()
        }

        addMethodPreprocessor(EditMessageText.PATH){
            it as EditMessageText
            it.disableWebPagePreview()
        }
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