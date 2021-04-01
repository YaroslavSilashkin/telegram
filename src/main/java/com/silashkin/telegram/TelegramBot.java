package com.silashkin.telegram;

import com.silashkin.telegram.botApi.Facade;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/*
 */
@Component
public class TelegramBot extends TelegramWebhookBot {

    private final Facade facade;
    @Getter
    private final String botUsername;
    @Getter
    private final String botPath;
    @Getter
    private final String botToken = System.getenv("BOT_TOKEN");

    @Autowired
    public TelegramBot(Facade facade, String botUserName, String botPath) {
        this.facade = facade;
        this.botUsername = botUserName;
        this.botPath = botPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return facade.handlerUpdate(update);
    }
}
