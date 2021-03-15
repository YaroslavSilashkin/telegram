package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Start implements HandlerInterface {

    private String nextState = "ThemeChoise";

    @Override
    public String getNextStateName() {
        return nextState;
    }

    @Override
    public SendMessage handle(Message message) {
        return new SendMessage().setText("Привет, это бот с вопросами интервью по java.");
    }
}
