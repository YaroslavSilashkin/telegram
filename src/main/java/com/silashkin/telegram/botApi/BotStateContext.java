package com.silashkin.telegram.botApi;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class BotStateContext {

    HashMap<BotState, HandlerInterface> states;

    public BotStateContext(List<BotState> botStates) {
        this.states = (HashMap<BotState, HandlerInterface>) botStates.stream().collect(Collectors.toMap(p -> p, t -> t.getStateHandler()));
    }

    public SendMessage processInputMessage(Message message, BotState botState) {
        HandlerInterface handler = findHandler(botState);
        handler.getNextState();
            return handler.handle(message);
    }

    private HandlerInterface findHandler(BotState botState) {
        return states.get(botState);
    }
}
