package com.silashkin.telegram.botApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Facade {

    private final BotContext botStateContext;

    @Autowired
    public Facade(BotContext botStateContext) {
        this.botStateContext = botStateContext;
    }

    public BotApiMethod<?> handlerUpdate(Update update) {
        BotApiMethod<?> replyMessage = null;

        if (update.hasCallbackQuery()) {
            return handleCallbackQuery(update);
        }

        Message message = update.getMessage();

        if (message != null && message.hasText()) {
            replyMessage = handleInputMessage(message);
        }
        return replyMessage;
    }

    private BotApiMethod<?> handleInputMessage(Message inputMessage) {
        Handler fromContextHandler = botStateContext.getByName(inputMessage.getText());
        return fromContextHandler.handle(inputMessage);
    }

    private BotApiMethod<?> handleCallbackQuery(Update update) {
       return botStateContext.getByName(update.getCallbackQuery().getData()).handle(update.getCallbackQuery().getMessage());
    }
}