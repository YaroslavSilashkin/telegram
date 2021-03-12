package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.BotState;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class UserCache implements Cache {

    private HashMap<Integer, BotState> userStates = new HashMap<>();

    @Override
    public BotState getState(int i) {
        return userStates.get(i);

    }
 
    @Override
    public boolean setState(int i, BotState botState) {
        userStates.put(i, botState);
        return true;

    }
}
