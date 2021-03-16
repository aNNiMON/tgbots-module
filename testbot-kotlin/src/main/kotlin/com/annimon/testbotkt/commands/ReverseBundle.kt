package com.annimon.testbotkt.commands

import com.annimon.tgbotsmodule.commands.CommandBundle
import com.annimon.tgbotsmodule.commands.CommandRegistry
import com.annimon.tgbotsmodule.commands.SimpleCommand
import com.annimon.tgbotsmodule.commands.SimpleInlineQueryCommand
import com.annimon.tgbotsmodule.commands.authority.For
import org.telegram.telegrambots.meta.api.methods.ParseMode
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent

class ReverseBundle : CommandBundle<For> {

    override fun register(commands: CommandRegistry<For>) {
        commands.register(SimpleCommand("/reverse", For.all()) { ctx ->
            ctx.reply(ctx.argumentsAsString().reversed()).callAsync(ctx.sender)
        })
        commands.register(SimpleInlineQueryCommand("reverse") { ctx ->
            if (ctx.argumentsAsString().isBlank()) {
                ctx.answerArticle("reverse_empty", "Type some text", InputTextMessageContent.builder()
                        .messageText("Type some text in inline mode and " +
                                "I'll reverse your text.\n" +
                                "Example: `reverse my cool text`")
                        .parseMode(ParseMode.MARKDOWN)
                        .build()
                ).callAsync(ctx.sender)
            } else {
                val rev = ctx.argumentsAsString().reversed()
                ctx.answerArticle(
                        "reverse_" + rev.hashCode(),
                        rev,
                        InputTextMessageContent("Your reversed text:\n$rev")
                ).callAsync(ctx.sender)
            }
        })
    }
}