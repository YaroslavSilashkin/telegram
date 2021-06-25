package com.silashkin.telegram.botApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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
        SendMessage replyMessage = null;
        Message message = update.getMessage();
        if (update.hasCallbackQuery()) {
            return handleCallbackQuery(update);
        }
        if (message != null && message.hasText()) {
            replyMessage = handleInputMessage(message);
        }
        return replyMessage;
    }

    private SendMessage handleInputMessage(Message inputMessage) {
        final Optional<String> inputMessageText = Optional.ofNullable(inputMessage.getText());
        final long chat = inputMessage.getChatId();
        HandlerInterface fromContextHandler = botStateContext.getByName(inputMessageText.orElse("Interception"));
        SendMessage replyMessage = fromContextHandler.handle(inputMessage);
        return replyMessage.setChatId(chat);
    }

    private BotApiMethod<?> handleCallbackQuery(Update update) {
       return botStateContext.getByName(update.getCallbackQuery().getData()).handle(update.getCallbackQuery().getMessage());
    }
}