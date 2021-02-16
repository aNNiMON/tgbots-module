package com.annimon.testbotkt

import com.annimon.tgbotsmodule.BotHandler
import com.annimon.tgbotsmodule.BotModule
import com.annimon.tgbotsmodule.Runner
import com.annimon.tgbotsmodule.beans.Config
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.KotlinModule

class TestBot : BotModule {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val profile = args.firstOrNull() ?: ""
            Runner.run(profile, listOf(TestBot()))
        }
    }

    override fun botHandler(config: Config): BotHandler {
        val configLoader = YamlConfigLoaderService<BotConfig>()
        val configFile = configLoader.configFile("testbot", config.profile)
        val botConfig = configLoader.load(configFile, BotConfig::class.java) {
            it.registerModule(KotlinModule())
        }
        return TestBotHandler(botConfig)
    }
}

data class BotConfig(
        @JsonProperty(required = true)
        val token: String,

        @JsonProperty(required = true)
        val username: String,

        @JsonProperty(required = true)
        val creatorId: Int
)