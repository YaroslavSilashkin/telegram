package com.silashkin.telegram;

import com.silashkin.telegram.botApi.BotState;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Getter
public class TelegramBot extends TelegramWebhookBot {

    private String botUsername;
    private String botPath;
    private BotState state;
    private String botToken = System.getenv("BOT_TOKEN");

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        state = BotState.START;
        if (update.getMessage() != null && update.getMessage().hasText()) {
            try {
                execute(new SendMessage(update.getMessage().getChatId(), update.getMessage().getText()));
                throw new TelegramApiException();
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
