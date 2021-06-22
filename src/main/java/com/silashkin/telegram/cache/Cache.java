package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.HandlerInterface;
import org.springframework.stereotype.Component;

@Component
public interface Cache {

    HandlerInterface getCacheHandler(long i);

    void setCacheHandler(long i, HandlerInterface handler);
}
