package com.annimon.testbotkt

import com.annimon.tgbotsmodule.BotHandler
import com.annimon.tgbotsmodule.BotModule
import com.annimon.tgbotsmodule.BotModuleOptions
import com.annimon.tgbotsmodule.Runner
import com.annimon.tgbotsmodule.beans.Config
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService
import com.fasterxml.jackson.annotation.JsonProperty
import tools.jackson.module.kotlin.KotlinModule

class TestBot : BotModule {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val profile = args.firstOrNull() ?: ""
            Runner.run(profile, listOf(TestBot()))
        }
    }

    override fun botHandler(config: Config): BotHandler {
        val configLoader = YamlConfigLoaderService()
        val configFile = configLoader.configFile("testbot", config.profile)
        val botConfig = configLoader.loadFile(configFile, BotConfig::class.java) {
            it.addModule(KotlinModule.Builder().build())
        }
        val botModuleOptions = BotModuleOptions.createDefault(botConfig.token);
        return TestBotHandler(botModuleOptions, botConfig)
    }
}

data class BotConfig(
        @JsonProperty(required = true)
        val token: String,

        @JsonProperty(required = true)
        val username: String,

        @JsonProperty(required = true)
        val creatorId: Long
)