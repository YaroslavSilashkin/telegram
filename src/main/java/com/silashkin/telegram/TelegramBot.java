package com.silashkin.telegram;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Setter
@Getter
public class TelegramBot extends TelegramWebhookBot {

    private String botUsername;
    private String botToken = System.getenv("BOT_TOKEN");
    private String botPath;

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            try {
                execute(new SendMessage(update.getMessage().getChatId(), update.getMessage().getText()));
            } catch (TelegramApiException ex) {
            }
        }
        return null;
    }
}
