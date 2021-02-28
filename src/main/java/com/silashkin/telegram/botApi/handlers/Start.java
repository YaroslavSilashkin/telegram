package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.BotState;
import com.silashkin.telegram.botApi.HandlerInterface;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Start implements HandlerInterface {

    private BotState botState = BotState.STARTSTATE;
    private BotState nextState = botState.THEMECHOISER;

    @Override
    public SendMessage handle(Message message) {
        return new SendMessage().setText("Привет, это бот с вопросами интервью по java");

    }

    @Override
    public BotState getState() {
        return botState;
    }

    @Override
    public BotState getNextState() {
        return nextState;
    }
}
