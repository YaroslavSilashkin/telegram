package com.silashkin.telegram.botApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BotContext {

    private HashMap<String, HandlerInterface> handlers;

    @Autowired
    public BotContext(List<HandlerInterface> handlers) {
        this.handlers = (HashMap<String, HandlerInterface>) handlers.stream().collect(Collectors.toMap(HandlerInterface::getName, t -> t));
    }

    public HandlerInterface getByName(String handlerName) {
        return handlers.get(handlerName);
    }

    public boolean contains(String key){
        return handlers.containsKey(key);
    }
}
