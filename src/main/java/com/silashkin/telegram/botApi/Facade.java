package com.silashkin.telegram.botApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@Component
public class Facade {

    private final BotContext botStateContext;

    @Autowired
    public Facade(BotContext botStateContext) {
        this.botStateContext = botStateContext;
    }

    public BotApiMethod<?> handlerUpdate(Update update) {
        BotApiMethod<?> replyMessage = null;
        Message message = update.getMessage();
        if (update.hasCallbackQuery()) {
            return handleCallbackQuery(update);
        }
        if (message != null && message.hasText()) {
            replyMessage = handleInputMessage(message);
        }
        return replyMessage;
    }

    private BotApiMethod<?> handleInputMessage(Message inputMessage) {
        final Optional<String> inputMessageText = Optional.ofNullable(inputMessage.getText());
        HandlerInterface fromContextHandler = botStateContext.getByName(inputMessageText.orElse("Interception"));
        BotApiMethod<?> botApiMethod = fromContextHandler.handle(inputMessage);
        return botApiMethod;
    }

    private BotApiMethod<?> handleCallbackQuery(Update update) {
       return botStateContext.getByName(update.getCallbackQuery().getData()).handle(update.getCallbackQuery().getMessage());
    }
}