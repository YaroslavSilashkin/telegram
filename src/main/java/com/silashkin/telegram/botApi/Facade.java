package com.silashkin.telegram.botApi;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 *
 * @author 1
 */
public class Facade {

    private BotState botState;

    public Facade(BotState botState) {
        this.botState = botState;
    }

    public SendMessage handlerUpdate(Update update) {
        SendMessage replyMessage = null;
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            replyMessage = handleInputMessage(message);
        }
        return replyMessage;
    }

    private SendMessage handleInputMessage(Message message) {
        SendMessage answer = new SendMessage();
        return answer;
    }
}
