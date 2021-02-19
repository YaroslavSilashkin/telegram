package com.silashkin.telegram.botApi.states;

import com.silashkin.telegram.botApi.BotState;
import com.silashkin.telegram.botApi.HandlerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartState implements BotState {

    private HandlerInterface themeChoise;

    @Autowired
    public StartState(HandlerInterface handlerInterface) {
        this.themeChoise = handlerInterface;
    }

    @Override
    public HandlerInterface getStateHandler() {
        return themeChoise;
    }

}
