package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class ThemeChoise implements HandlerInterface {

    private String botState = "/";
    private String nextState = "";

    @Override
    public SendMessage handle(Message message) {
        return new SendMessage().setText("ответ");
    }

    @Override
    public String getName() {
        return botState;
    }

    @Override
    public String setNextState() {
        return nextState;
    }
}
