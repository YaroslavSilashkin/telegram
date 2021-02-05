package com.silashkin.telegram.botApi;

import com.silashkin.telegram.botApi.states.StartState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Facade {

    BotStateContext botStateContext;
    BotState botState = new StartState();

    @Autowired
    public Facade(BotStateContext botStateContext) {
        this.botStateContext = botStateContext;
//        

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
        SendMessage replyMessage;
        String inputMsg = message.getText();
        long chatId = message.getChatId();
        replyMessage = botStateContext.processInputMessage(message, botState);

        return replyMessage;
    }
}
