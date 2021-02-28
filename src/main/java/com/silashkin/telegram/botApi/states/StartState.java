package com.silashkin.telegram.botApi.states;

import com.silashkin.telegram.botApi.HandlerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartState {

    private HandlerInterface themeChoise;

    @Autowired
    public StartState(HandlerInterface handlerInterface) {
        this.themeChoise = handlerInterface;
    }

    public HandlerInterface getStateHandler() {
        return themeChoise;
    }

}
