package com.annimon.testbotkt

import com.annimon.tgbotsmodule.BotHandler
import com.annimon.tgbotsmodule.api.methods.Methods
import com.annimon.tgbotsmodule.commands.CommandRegistry
import com.annimon.tgbotsmodule.commands.SimpleCommand
import com.annimon.tgbotsmodule.commands.authority.For
import com.annimon.tgbotsmodule.commands.authority.SimpleAuthority
import com.annimon.tgbotsmodule.services.ResourceBundleLocalizationService
import org.telegram.telegrambots.meta.api.methods.ActionType
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class TestBotHandler(private val botConfig: BotConfig) : BotHandler() {
    val authority = SimpleAuthority(this, botConfig.creatorId)
    val commands = CommandRegistry(this, authority)

    var globalLocale = "en"
    val localization = ResourceBundleLocalizationService("Language")

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
        commands.registerBundle { registry ->
            registry.register(SimpleCommand("/hello_global", For.ALL) { ctx ->
                // Sends hello message according to global locale
                ctx.reply(localization.getString("hello", globalLocale)).callAsync(ctx.sender)
            })
            registry.register(SimpleCommand("/hello_local", For.ALL) { ctx ->
                // Sends hello message according to user language code
                ctx.reply(localization.getString("hello", ctx.user().languageCode ?: globalLocale))
                        .callAsync(ctx.sender)
            })
            registry.register(SimpleCommand("/switch_language", For.ALL) { ctx ->
                // Setup inline keyboard
                val keyboard = ArrayList<List<InlineKeyboardButton>>(2)
                for (lang in listOf("en", "ru")) {
                    val languageName = localization.getString("lang_" + lang, globalLocale)
                    val btn = InlineKeyboardButton.builder()
                            .text(languageName)
                            .callbackData(lang)
                            .build()
                    keyboard.add(listOf(btn))
                }

                ctx.reply(localization.getString("choose_language", globalLocale))
                        .setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(keyboard).build())
                        .callAsync(ctx.sender)
            })
        }
    }

    override fun onUpdate(update: Update): BotApiMethod<*>? {
        if (update.hasCallbackQuery()) {
            // Switch global language
            update.callbackQuery.message?.let { message ->
                globalLocale = update.callbackQuery.data ?: "en"
                Methods.editMessageText()
                        .setChatId(message.chatId)
                        .setMessageId(message.messageId)
                        .setText(localization.getString("language_set", globalLocale))
                        .callAsync(this)
            }
            return null
        }
        if (commands.handleUpdate(update)) {
            return null
        }
        // handle other updates
        return null
    }

    override fun getBotUsername() = botConfig.username

    override fun getBotToken() = botConfig.token
}