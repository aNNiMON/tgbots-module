package com.annimon.testbotkt

import com.annimon.tgbotsmodule.BotHandler
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import java.io.Serializable
import java.util.function.Consumer

fun <T: Serializable> BotApiMethod<T>.call(handler: BotHandler): T? {
    return handler.call(this)
}

fun <T: Serializable> BotApiMethod<T>.callAsync(handler: BotHandler) {
    handler.callAsync(this)
}

fun <T: Serializable> BotApiMethod<T>.callAsync(handler: BotHandler,
                                                responseConsumer: Consumer<T>) {
    handler.callAsync(this, responseConsumer)
}
