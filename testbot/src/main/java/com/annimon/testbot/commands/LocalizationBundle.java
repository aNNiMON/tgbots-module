package com.annimon.testbot.commands;

import com.annimon.tgbotsmodule.commands.CommandBundle;
import com.annimon.tgbotsmodule.commands.CommandRegistry;
import com.annimon.tgbotsmodule.commands.SimpleCallbackQueryCommand;
import com.annimon.tgbotsmodule.commands.SimpleCommand;
import com.annimon.tgbotsmodule.commands.authority.For;
import com.annimon.tgbotsmodule.commands.context.MessageContext;
import com.annimon.tgbotsmodule.services.LocalizationService;
import com.annimon.tgbotsmodule.services.ResourceBundleLocalizationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

public class LocalizationBundle implements CommandBundle<For> {

    private String globalLocale;
    private final LocalizationService localization;

    public LocalizationBundle() {
        globalLocale = "en";
        localization = new ResourceBundleLocalizationService("Language");
    }

    @Override
    public void register(@NotNull CommandRegistry<For> registry) {
        registry.splitCallbackCommandByColon();
        registry.register(new SimpleCallbackQueryCommand("lang", ctx -> {
            // Switch global language
            globalLocale = ctx.argument(0, "en");
            ctx.editMessage(localization.getString("language_set", globalLocale))
                    .callAsync(ctx.sender);
        }));
        registry.register(new SimpleCommand("/hello_global", ctx -> {
            // Sends hello message according to global locale
            ctx.reply(localization.getString("hello", globalLocale)).callAsync(ctx.sender);
        }));
        registry.register(new SimpleCommand("/hello_local", ctx -> {
            // Sends hello message according to user language code
            final var languageCode = ctx.user().getLanguageCode();
            final var userLocale = Optional.ofNullable(languageCode).orElse(globalLocale);
            ctx.reply(localization.getString("hello", userLocale)).callAsync(ctx.sender);
        }));
        registry.register(new SimpleCommand("/switch_language", this::switchLanguage));
    }

    private void switchLanguage(MessageContext ctx) {
        // Setup inline keyboard
        final var keyboard = new ArrayList<InlineKeyboardRow>(2);
        for (var lang : List.of("en", "ru")) {
            var languageName = localization.getString("lang_" + lang, globalLocale);
            var btn = InlineKeyboardButton.builder()
                    .text(languageName)
                    .callbackData("lang:" + lang)
                    .build();
            keyboard.add(new InlineKeyboardRow(btn));
        }

        ctx.reply(localization.getString("choose_language", globalLocale))
                .setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(keyboard).build())
                .callAsync(ctx.sender);
    }
}
