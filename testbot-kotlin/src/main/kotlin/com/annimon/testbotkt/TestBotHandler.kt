package com.annimon.testbotkt

import com.annimon.testbotkt.commands.LocalizationBundle
import com.annimon.testbotkt.commands.ReverseBundle
import com.annimon.tgbotsmodule.BotHandler
import com.annimon.tgbotsmodule.BotModuleOptions
import com.annimon.tgbotsmodule.api.methods.Methods
import com.annimon.tgbotsmodule.commands.CommandRegistry
import com.annimon.tgbotsmodule.commands.SimpleCommand
import com.annimon.tgbotsmodule.commands.authority.For
import com.annimon.tgbotsmodule.commands.authority.SimpleAuthority
import org.telegram.telegrambots.meta.api.methods.ActionType
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.polls.input.InputPollOption
import kotlin.math.abs

class TestBotHandler(botModuleOptions: BotModuleOptions, private val botConfig: BotConfig) : BotHandler(botModuleOptions) {
    private val authority = SimpleAuthority(botConfig.creatorId)
    private val commands = CommandRegistry(botConfig.username, authority)

    init {
        commands.register(SimpleCommand("/action", For.CREATOR) { ctx ->
            if (ctx.argumentsLength() == 1) {
                Methods.sendChatAction(ctx.chatId(), ActionType.get(ctx.argument(0, ActionType.TYPING.toString())))
                        .callAsync(ctx.sender)
            }
        })
        commands.register(SimpleCommand("/effect", For.all()) { ctx ->
            val effects = arrayOf(
                "5104841245755180586", "5107584321108051014", "5104858069142078462",
                "5104858069142078462", "5044134455711629726", "5046509860389126442", "5046589136895476101"
            )
            val text: String
            val effectId: String?
            if (ctx.message().isUserMessage) {
                effectId = effects[(abs(System.currentTimeMillis() % effects.size)).toInt()]
                text = "Message effect `${effectId}`"
            } else {
                text = "Message effects works only in private chats"
                effectId = null
            }
            ctx.reply(text)
                .enableMarkdown()
                .setMessageEffectId(effectId)
                .callAsync(ctx.sender)
        })

        // Polls
        commands.register(SimpleCommand("/poll", For.all()) { ctx ->
            val lines = ctx.argumentsAsString().lines().filterNot { it.isBlank() }
            if (lines.size <= 3) {
                ctx.reply("At least 3 lines expected").callAsync(ctx.sender)
            } else {
                Methods.Polls.sendPoll(ctx.chatId())
                        .setQuestion(lines[0])
                        .setOptions(lines.drop(1).map { InputPollOption(it) })
                        .callAsync(ctx.sender)
            }
        })
        commands.register(SimpleCommand("/stoppoll", For.all()) { ctx ->
            if (!ctx.message().isReply) {
                ctx.reply("reply with this command to a poll message").callAsync(ctx.sender)
            } else {
                Methods.Polls.stopPoll(ctx.chatId(), ctx.message().replyToMessage.messageId)
                        .callAsync(ctx.sender)
            }
        })

        commands.registerBundle(LocalizationBundle())
        commands.registerBundle(ReverseBundle())

        addMethodPreprocessor(SendMessage::class.java) {
            it.allowSendingWithoutReply = true
            it.disableWebPagePreview()
        }
        addMethodPreprocessor(EditMessageText::class.java) {
            it.disableWebPagePreview()
        }
        addMethodPreprocessor(SendPhoto::class.java) {
            it.protectContent = true
        }
    }

    override fun onUpdate(update: Update): BotApiMethod<*>? {
        if (commands.handleUpdate(this, update)) {
            return null
        }
        // handle other updates
        return null
    }
}