package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class ThemeChoise implements HandlerInterface {

    private String state = "/";
    HandlerInterface nextState;
    HandlerInterface handler;

    @Override
    public String getState() {
        return state;
    }

    @Override
    public SendMessage handle(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
