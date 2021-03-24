package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.HandlerInterface;
import org.springframework.stereotype.Component;

@Component
public interface Cache {

    HandlerInterface getCacheHandler(int i);

    void setCacheHandler(int i, HandlerInterface handler);
}
