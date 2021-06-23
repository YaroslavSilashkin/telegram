package com.silashkin.telegram.botApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Facade {

    private final BotContext botStateContext;

    @Autowired
    public Facade(BotContext botStateContext) {
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

        HandlerInterface fromContextHandler = botStateContext.getByName(inputMessageText);
        handler = fromContextHandler;
        if (handler == null) {
            return null;
        }
        replyMessage = handler.handle(inputMessage);
        return replyMessage.setChatId(chat);
    }
}
