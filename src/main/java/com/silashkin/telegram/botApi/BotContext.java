package com.silashkin.telegram.botApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BotContext {

    private final HashMap<String, Handler> handlers;

    @Autowired
    public BotContext(List<Handler> handlers) {
        this.handlers = (HashMap<String, Handler>) handlers.stream().collect(Collectors.toMap(Handler::getName, t -> t));
    }

    public Handler getByName(String handlerName) {
        return Optional.ofNullable(handlers.get(handlerName)).orElse(handlers.get("Interception"));
    }
}
