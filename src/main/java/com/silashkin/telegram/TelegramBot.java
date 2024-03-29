package com.silashkin.telegram;

import com.silashkin.telegram.botApi.Facade;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramWebhookBot {

    private final Facade facade;
    @Getter
    private String botUsername;
    @Getter
    private String botPath;
    @Getter
    private final String botToken = System.getenv("BOT_TOKEN");

    @Autowired
    public TelegramBot(Facade facade) {
        this.facade = facade;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return facade.handlerUpdate(update);
    }
}
