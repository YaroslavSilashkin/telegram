package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.HandlerInterface;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class UserCache implements Cache {

    private final HashMap<Long, HandlerInterface> userHandlers = new HashMap<>();

    @Override
    public HandlerInterface getCacheHandler(long i) {
        return userHandlers.get(i);
    }

    @Override
    public void setCacheHandler(long i, HandlerInterface handler) {
        userHandlers.put(i, handler);
    }
}
