# tgbots-module

Enhanced Java telegram bots runner built on top of the [Telegram Bots](https://github.com/rubenlagus/TelegramBots) library.

## Why?

 - I want separate projects per bots.
 - I want to easily switch between long polling and webhook methods without recompiling the application.
 - I want to easily disable bots without recompiling the application.
 - I want yaml configs to store bot tokens and other data.
 - I want different profiles for configs.
 - I want command system with roles support.
 - I want localization support.

## Example

 [@tgbotsmodulebot](https://t.me/tgbotsmodulebot) ([source code](https://github.com/annimon-tutorials/tgbotsmodule-webhook-bot))

 
## Usage
 
 - Add gradle dependency:
 
    ```groovy
    implementation 'com.annimon:tgbots-module:6.5.0'
    ```

 - Implement `BotModule` interface:
 
    ```java
    public class TestBot implements BotModule {   
       @Override
       public BotHandler botHandler(Config config) {
           super(config.getToken());
           return new TestBotHandler();
       }
    }
    ```
 
 - _[Optional]_ Add main method to run single project:
 
    ```java
    public class TestBot implements BotModule {   
       public static void main(String[] args) {
           final var profile = (args.length >= 1) ? args[0] : "";
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
           final var configLoader = new YamlConfigLoaderService();
           final var configFile = configLoader.configFile("testbot", config.getProfile());
           final var botConfig = configLoader.loadFile(configFile, BotConfig.class);
           return new TestBotHandler(botConfig);
       }
    }
    ```

 - Fill in `config.yaml` (See [Webhooks](#webhooks) examples):
 
    ```yaml
    log-level: FINE
    webhook:
      enabled: false
      port: env(PORT:8443)
      externalUrl: https://123.45.67.890:$port
      internalUrl: http://0.0.0.0:$port
      keystorePath: cert/keystore.jks
      keystorePassword: env(KEYSTORE_PASSWORD)
    modules:
      - com.annimon.testbot.TestBot
    ```
 
 - Happy bots developing:
 
    ```java
    public class TestBotHandler extends BotHandler {
    
        private final BotConfig botConfig;
    
        public TestBotHandler(BotConfig botConfig) {
            super(botConfig.getToken());
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
    }
    ```

Now you can easily switch between webhook and long polling methods by changing the `webhook:` `enabled` flag in `config,yaml`.

Or you can create `config-test.yaml` and run the `test` profile:

```
java -cp tgbots-module.jar:testbot.jar:yourfavoritebot.jar com.annimon.telegrambots.Runner test
```


## Webhooks

### Heroku

Heroku starts on a random port, you can get a value from the environment property `PORT`:

 ```yaml
 webhook:
   enabled: true
   port: env(PORT)
   externalUrl: https://yourappname.herokuapp.com
   internalUrl: http://0.0.0.0:$port
 ```

### Self-hosted

Use `certgen.sh` to generate a certificate (replace `SERVERIPADDRESS` with the server's IP address):

```bash
JKS=keystore.jks
CERT=public_cert.pem

openssl req -newkey rsa:2048 -sha256 -nodes \
    -keyout private.key -x509 \
    -days 365 \
    -out $CERT \
    -subj "/C=US/ST=Utah/L=Location/O=Organization/CN=SERVERIPADDRESS"

openssl pkcs12 -export \
    -in $CERT \
    -inkey private.key \
    -certfile $CERT \
    -out keystore.p12

keytool -importkeystore \
    -srckeystore keystore.p12 \
    -srcstoretype pkcs12 \
    -sigalg SHA1withRSA \
    -destkeystore $JKS \
    -deststoretype pkcs12

rm keystore.p12 private.key
```

The keystore password will be asked several times during the generation of the certificate. Don't forget to `export` it:

```bash
export KEYSTORE_PASSWORD=mysupersecretpasswordis123456
```

Specify generated `keystore.jks` and `public_cert.pem` paths and your `SERVERIPADDRESS` in `config.yaml`: 

 ```yaml
 webhook:
   enabled: true
   port: 8443
   externalUrl: https://SERVERIPADDRESS:$port
   internalUrl: http://0.0.0.0:$port
   keystorePath: cert/keystore.jks
   keystorePassword: env(KEYSTORE_PASSWORD)
   certificatePublicKeyPath: cert/public_cert.pem
 ```
