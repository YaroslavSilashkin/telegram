package com.silashkin.telegram.cache;

import com.silashkin.telegram.botApi.BotState;
import org.springframework.stereotype.Component;

@Component
public interface Cache {

    BotState getState(int i);

    Boolean setState(int i, BotState botState);
}
