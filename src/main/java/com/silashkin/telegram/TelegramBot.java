package com.silashkin.telegram;

import com.silashkin.telegram.botApi.Facade;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Getter
public class TelegramBot extends TelegramWebhookBot {

    private Facade facade;

    private String botUsername;
    private String botPath;
    private String botToken = System.getenv("BOT_TOKEN");

    @Autowired
    public TelegramBot(Facade facade) {
        this.facade = facade;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return facade.handlerUpdate(update);
    }
}
