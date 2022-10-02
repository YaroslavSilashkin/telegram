package com.silashkin.telegram.botApi;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Handler {

    BotApiMethod<?> handle(Message message);

    String getName();
}
