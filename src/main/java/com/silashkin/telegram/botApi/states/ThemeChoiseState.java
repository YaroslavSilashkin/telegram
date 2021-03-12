package com.silashkin.telegram.botApi.states;

import com.silashkin.telegram.botApi.BotState;
import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.botApi.handlers.ThemeChoise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThemeChoiseState implements BotState {

    private String name = "ThemeChoise";
    private HandlerInterface handlerInterface;

    @Autowired
    public ThemeChoiseState(ThemeChoise handlerInterface) {
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
