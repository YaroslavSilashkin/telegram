package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.BotState;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class UserCache implements Cache {

    HashMap<Integer, BotState> userStates;

    @Override
    public BotState getState(long i) {
        return userStates.get(i);
    }

    @Override
    public Boolean setState(int i, BotState botState) {
        userStates.put(i, botState);
        return true;
    }
}
