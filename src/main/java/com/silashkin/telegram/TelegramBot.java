package com.silashkin.telegram;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Getter
@Component
public class TelegramBot extends TelegramWebhookBot {

    private static final String BOT_TOKEN = "1152592908:AAEiPxwMQMV0Evvy8o48u_dZxNzPMArxMKE";
    @Value("${username}")
    private static String BOT_USERNAME;
    private static final String BOT_PATH = "https://telegrambotnn.herokuapp.com/";
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
