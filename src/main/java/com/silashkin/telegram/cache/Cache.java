package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.Handler;
import org.springframework.stereotype.Component;

@Component
public interface Cache {

    Handler getCacheHandler(long chat);

    void setCacheHandler(long chat, Handler handler);
}
