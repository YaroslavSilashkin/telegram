package com.silashkin.telegram.botApi;

import org.springframework.stereotype.Component;

@Component
public interface BotState {

    HandlerInterface getStateHandler();
}
