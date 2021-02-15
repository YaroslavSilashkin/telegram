package com.silashkin.telegram.botApi.states;

import com.silashkin.telegram.botApi.BotState;
import org.springframework.stereotype.Component;

@Component
public class StartState implements BotState {

    @Override
    public String state() {
        return this.toString();
    }
}
