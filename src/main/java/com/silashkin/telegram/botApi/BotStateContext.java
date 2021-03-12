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

    private HashMap<String, BotState> states;

    @Autowired
    public BotStateContext(List<BotState> states) {
        this.states = (HashMap<String, BotState>) states.stream().collect(Collectors.toMap(p -> p.getStateName(), t -> t));
    }

    public BotState getStateByName(String botStateName) {
        BotState botState;
        botState = states.get(botStateName);
        return botState;
    }

    public SendMessage processInputMessage(Message message, BotState botState) {
        HandlerInterface handler = findHandler(botState);
        return handler.handle(message);
    }

    private HandlerInterface findHandler(BotState botState) {
        return botState.getStateHandler();
    }
}
