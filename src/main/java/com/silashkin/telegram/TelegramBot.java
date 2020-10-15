package com.silashkin.telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramWebhookBot {

    private static final String BOT_TOKEN = "1152592908:AAEiPxwMQMV0Evvy8o48u_dZxNzPMArxMKE";
    private static final String BOT_USERNAME = "@testninobot";
    private static final String BOT_PATH = "https://6d8822686023.ngrok.io ";

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            try {
                execute(new SendMessage(update.getMessage().getChatId(), "test"));
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
        return new SendMessage().setText("test");
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
