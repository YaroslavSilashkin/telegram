package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.HandlerInterface;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class UserCache implements Cache {

    private final HashMap<Integer, HandlerInterface> userHandlers = new HashMap<>();

    @Override
    public HandlerInterface getCacheHandler(int i) {
        return userHandlers.get(i);
    }

    @Override
    public void setCacheHandler(int i, HandlerInterface handler) {
        userHandlers.put(i, handler);
    }
}
