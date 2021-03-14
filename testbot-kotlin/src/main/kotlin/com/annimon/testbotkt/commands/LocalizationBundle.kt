package com.annimon.testbotkt.commands

import com.annimon.tgbotsmodule.commands.CommandBundle
import com.annimon.tgbotsmodule.commands.CommandRegistry
import com.annimon.tgbotsmodule.commands.SimpleCallbackQueryCommand
import com.annimon.tgbotsmodule.commands.SimpleCommand
import com.annimon.tgbotsmodule.commands.context.MessageContext
import com.annimon.tgbotsmodule.services.ResourceBundleLocalizationService
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton

class LocalizationBundle : CommandBundle {

    private var globalLocale = "en"
    private val localization = ResourceBundleLocalizationService("Language")

    override fun register(registry: CommandRegistry) {
        registry.splitCallbackCommandByColon()
        registry.register(SimpleCallbackQueryCommand("lang") { ctx ->
            // Switch global language
            globalLocale = ctx.argument(0, "en")
            ctx.editMessage(localization.getString("language_set", globalLocale))
                    .callAsync(ctx.sender)
        })
        registry.register(SimpleCommand("/hello_global") { ctx ->
            // Sends hello message according to global locale
            ctx.reply(localization.getString("hello", globalLocale)).callAsync(ctx.sender)
        })
        registry.register(SimpleCommand("/hello_local") { ctx ->
            // Sends hello message according to user language code
            val userLocale = ctx.user().languageCode ?: globalLocale
            ctx.reply(localization.getString("hello", userLocale))
                    .callAsync(ctx.sender)
        })
        registry.register(SimpleCommand("/switch_language", this::switchLanguage))
    }

    private fun switchLanguage(ctx: MessageContext) {
        // Setup inline keyboard
        val keyboard = ArrayList<List<InlineKeyboardButton>>(2)
        for (lang in listOf("en", "ru")) {
            val languageName = localization.getString("lang_$lang", globalLocale)
            val btn = InlineKeyboardButton.builder()
                    .text(languageName)
                    .callbackData("lang:$lang")
                    .build()
            keyboard.add(listOf(btn))
        }

        ctx.reply(localization.getString("choose_language", globalLocale))
                .setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(keyboard).build())
                .callAsync(ctx.sender)
    }
}