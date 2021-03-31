package com.silashkin.telegram.botApi;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class BotStateContext {

    private HashMap<String, HandlerInterface> handlers;

    @Autowired
    public BotStateContext(List<HandlerInterface> handlers) {
        this.handlers = (HashMap<String, HandlerInterface>) handlers.stream().
                collect(Collectors.toMap(p -> p.getName(), t -> t));
    }

    public HandlerInterface getByName(String handlerName) {
        HandlerInterface handler;
        handler = handlers.get(handlerName);
        return handler;
    }

    //refactor аргументы функции имя хэндлера
    public SendMessage processInputMessage(Message message, HandlerInterface handler) {
        return handler.handle(message);
    }
}
