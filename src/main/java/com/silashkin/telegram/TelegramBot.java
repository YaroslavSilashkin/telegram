package com.silashkin.telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramWebhookBot {

    private static final String BOT_TOKEN = "${bottoken}";
    private static final String BOT_USERNAME = "${username}";
    private static final String BOT_PATH = "https://telegrambotnn.herokuapp.com/";

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            try {
                execute(new SendMessage(update.getMessage().getChatId(), "answer"));
            } catch (TelegramApiException ex) {
            }
        }
        return new SendMessage().setText("message");
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotPath() {
        return BOT_PATH;
    }
}
