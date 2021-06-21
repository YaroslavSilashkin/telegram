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
    private BotContext botStateContext;

    @Autowired
    public Facade(UserCache userCache, BotContext botStateContext) {
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

    private SendMessage handleInputMessage(Message inputMessage) {
        SendMessage replyMessage;
        HandlerInterface handler;
        final String inputMessageText = inputMessage.getText();
        final long chat = inputMessage.getChatId();
        //refactor this
        HandlerInterface fromContextHandler = botStateContext.getByName(inputMessageText);
        HandlerInterface fromCacheHandler = userCache.getCacheHandler((int) chat);
        handler = fromCacheHandler;

        if (fromContextHandler != null) {
            handler = fromContextHandler;
        }
        if (handler == null) {
            return null;
        }

        replyMessage = handler.handle(inputMessage);
        userCache.setCacheHandler((int) chat, botStateContext.getByName(handler.getNextHandlerName()));
        return replyMessage.setChatId(chat);
    }
}
