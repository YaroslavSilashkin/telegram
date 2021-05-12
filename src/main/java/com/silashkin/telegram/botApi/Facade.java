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

    private SendMessage handleInputMessage(Message InputMessage) {
        SendMessage replyMessage;
        HandlerInterface handler;
        long chat = InputMessage.getChatId();
        HandlerInterface fromContextHandler = botStateContext.getByName(InputMessage.getText());
        HandlerInterface fromCacheHandler = userCache.getCacheHandler((int) chat);
        handler = fromCacheHandler;
        //refactor передавать не хэндлер а имя
        if (InputMessage.getText().equals("/")) {
            handler = botStateContext.getByName("/Start");
        }
        if (fromContextHandler != null) {
            handler = fromContextHandler;
        }
        if (handler == null) {
            return null;
        }

        replyMessage = handler.handle(InputMessage);
        userCache.setCacheHandler((int) chat, botStateContext.getByName(handler.getNextHandlerName()));
        return replyMessage.setChatId(chat);
    }
}
