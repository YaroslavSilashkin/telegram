package com.silashkin.telegram.botApi;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class BotStateContext {

    HashMap<String, HandlerInterface> handlers = new HashMap<>();

    public BotStateContext(List<HandlerInterface> handlers) {
        this.handlers = (HashMap<String, HandlerInterface>) handlers.stream().collect(Collectors.toMap(p -> p.getState(), t -> t));
    }

    public SendMessage processInputMessage(Message message, BotState botState) {
        return handlers.get(findHandler(botState)).handle(message);
    }

    private HandlerInterface findHandler(BotState botState) {
        return handlers.get(botState);
    }
}
