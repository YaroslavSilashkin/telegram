package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.Handler;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class UserCache implements Cache {

    private final HashMap<Long, Handler> userHandlers = new HashMap<>();

    @Override
    public Handler getCacheHandler(long i) {
        return userHandlers.get(i);
    }

    @Override
    public void setCacheHandler(long i, Handler handler) {
        userHandlers.put(i, handler);
    }
}
