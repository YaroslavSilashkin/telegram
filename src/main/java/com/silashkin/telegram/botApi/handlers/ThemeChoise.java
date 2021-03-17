package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class ThemeChoise implements HandlerInterface {

    private String nextState = "ThemeChoise";
    private Content botContent;

    @Autowired
    public ThemeChoise(Content botContent) {
        this.botContent = botContent;
    }

    @Override
    public String getNextStateName() {
        return nextState;
    }

    @Override
    public SendMessage handle(Message message) {
        return new SendMessage().setText("Список тем:" + "\n" + botContent.getContent());

    }
}
