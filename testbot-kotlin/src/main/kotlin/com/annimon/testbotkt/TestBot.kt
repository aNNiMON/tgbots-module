package com.annimon.testbotkt

import com.annimon.tgbotsmodule.BotHandler
import com.annimon.tgbotsmodule.BotModule
import com.annimon.tgbotsmodule.Runner
import com.annimon.tgbotsmodule.beans.Config
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank

class TestBot : BotModule {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val profile = if (args.isNotEmpty() && !args[0].isEmpty()) args[0] else ""
            Runner.run(profile, listOf(TestBot()))
        }
    }

    override fun botHandler(config: Config): BotHandler {
        val configLoader = YamlConfigLoaderService<BotConfig>()
        val configFile = configLoader.configFile("testbot", config.profile)
        val botConfig = configLoader.load(configFile, BotConfig::class.java)
        return TestBotHandler(botConfig)
    }
}

data class BotConfig(
        @NotBlank
        @JsonProperty(required = true)
        val token: String,

        @NotBlank
        @JsonProperty(required = true)
        val username: String
)