package com.silashkin.telegram.botApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import com.silashkin.telegram.cache.UserCache;

@Component
public class Facade {

    private BotStateContext botStateContext;

    @Autowired
    public Facade(UserCache userDataCache, BotStateContext botStateContext) {
        this.botStateContext = botStateContext;
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
        String botState;
        botState = botStateContext.handlers.get(message.getText()).getName();
        long chatId = message.getChatId();
        replyMessage = botStateContext.processInputMessage(message, botState);
        return replyMessage.setChatId(chatId);
    }
}
