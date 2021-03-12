package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.BotState;
import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.botApi.states.ThemeChoiseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Start implements HandlerInterface {

    private BotState nextState;

    @Autowired
    public Start(ThemeChoiseState nextState) {
        this.nextState = nextState;
    }

    @Override
    public BotState getNextState() {
        return nextState;
    }

    @Override
    public SendMessage handle(Message message) {
        return new SendMessage().setText("Привет, это бот с вопросами интервью по java.");
    }
}
