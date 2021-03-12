package com.silashkin.telegram.botApi.states;

import com.silashkin.telegram.botApi.BotState;
import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.botApi.handlers.Start;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartState implements BotState {

    private String name = "Start";
    private HandlerInterface handlerInterface;

    @Autowired
    public StartState(Start handlerInterface) {
        this.handlerInterface = handlerInterface;
    }

    @Override
    public String getStateName() {
        return name;
    }

    @Override
    public HandlerInterface getStateHandler() {
        return handlerInterface;
    }
}
