package com.annimon.tgbotsmodule.commands;

import com.annimon.tgbotsmodule.commands.context.RegexMessageContext;
import java.util.regex.Pattern;

public interface RegexCommand extends Command<RegexMessageContext> {

    Pattern pattern();
}
