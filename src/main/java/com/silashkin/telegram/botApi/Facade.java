package com.silashkin.telegram.botApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import com.silashkin.telegram.cache.UserCache;

@Component
public class Facade {

    private UserCache userCache;
    private BotStateContext botStateContext;

    @Autowired
    public Facade(UserCache userCache, BotStateContext botStateContext) {
        this.userCache = userCache;
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
        BotState botState;
        long chat = message.getChatId();
        BotState stateByName = botStateContext.getStateByName(message.getText());
        BotState cacheState = userCache.getState((int) chat);
        botState = cacheState;
        if (message.getText() == "/") {
            botState = botStateContext.getStateByName("Start");
        }
        if (stateByName != null) {
            botState = stateByName;
        }
        if (botState == null) {
            return null;
        }

        replyMessage = botStateContext.processInputMessage(message, botState);
        userCache.setState((int) chat, botStateContext.getStateByName(botState.getStateHandler().getNextStateName()));
        return replyMessage.setChatId(chat);
    }
}
