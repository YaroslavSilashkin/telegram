package com.silashkin.telegram.botApi;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class BotStateContext {

    HashMap<String, HandlerInterface> handlers;

    public BotStateContext(List<HandlerInterface> handlers) {
        this.handlers = (HashMap<String, HandlerInterface>) handlers.stream().collect(Collectors.toMap(p -> p.getName(), t -> t));
    }

    public SendMessage processInputMessage(Message message, String botState) {
        return findHandler(botState).handle(message);
    }

    private HandlerInterface findHandler(String botState) {
        return handlers.get(botState);
    }
}