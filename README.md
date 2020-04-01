# tgbots-module

Simple Java telegram bots runner built on top of the [Telegram Bots](https://github.com/rubenlagus/TelegramBots) library.

## Why?

 - I want separate projects per bots.
 - I want to easily switch between long polling and webhook methods without recompiling the application.
 - I want to easily disable bots without recompiling the application.
 - I want yaml configs to store bot tokens and other data.
 - I want different profiles for configs.
 - I want command support with roles support.
 - I want localization support.
 
## Usage
 
 - Add gradle dependency:
 
    ```groovy
    compile 'com.annimon:tgbots-module:0.9'
    ```

 - Implement `BotModule` interface:
 
    ```java
    public class TestBot implements BotModule {   
       @Override
       public BotHandler botHandler(Config config) {
           return new TestBotHandler();
       }
    }
    ```
 
 - _[Optional]_ Add main method to run single project:
 
    ```java
    public class TestBot implements BotModule {   
       public static void main(String[] args) {
           final var profile = (args.length >= 1 && !args[0].isEmpty()) ? args[0] : "";
           Runner.run(profile, List.of(new TestBot()));
       }
       // ...
    }
    ```
 
 - _[Optional]_ Add yaml configuration support:
 
    ```java
    import lombok.Data;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import javax.validation.constraints.NotBlank;
    
    @Data
    public class BotConfig {
    
        @NotBlank
        @JsonProperty(required = true)
        private String token;
    
        @NotBlank
        @JsonProperty(required = true)
        private String username;
    }
    ```
    
    `testbot.yaml`
    ```yaml
    token: 123456789:ABCDEFGHIJKLM_NOPQRSTUVWXYZ01234567
    username: bot
    ```
    
    ```java
    public class TestBot implements BotModule {   
       // ...
       @Override
       public BotHandler botHandler(Config config) {
           final var configLoader = new YamlConfigLoaderService<BotConfig>();
           final var configFile = configLoader.configFile("testbot", config.getProfile());
           final var botConfig = configLoader.load(configFile, BotConfig.class);
           return new TestBotHandler(botConfig);
       }
    }
    ```

 - Fill in `config.yaml`:
 
    ```yaml
    log-level: FINE
    webhook:
      enabled: false
      port: env(PORT:8443)
      externalUrl: https://123.45.67.89:$port
      internalUrl: https://123.45.67.89:$port
      certificatePublicKeyPath: cert/public_cert.pem
      certificateStorePath: cert/keystore.jks
      certificateStorePassword: env(STORE_PASSWORD)
    modules:
      - com.annimon.testbot.TestBot
    ```
 
 - Happy bots developing:
 
    ```java
    public class TestBotHandler extends BotHandler {
    
        private final BotConfig botConfig;
    
        public TestBotHandler(BotConfig botConfig) {
            this.botConfig = botConfig;
        }
    
        @Override
        public BotApiMethod onUpdate(Update update) {
            // your code here
            return null;
        }
    
        @Override
        public String getBotUsername() {
            return botConfig.getUsername();
        }
    
        @Override
        public String getBotToken() {
            return botConfig.getToken();
        }
    }
    ```

Now you can easily switch between webhook and longpolling methods by changing the `webhook:` `enabled` flag in `config,yaml`.

Or you can create `config-test.yaml` and run the `test` profile:

```
java -cp tgbots-module.jar:testbot.jar:yourfavoritebot.jar com.annimon.telegrambots.Runner test
```

