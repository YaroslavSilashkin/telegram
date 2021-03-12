package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.BotState;
import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.cache.UserCache;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class ThemeChoise implements HandlerInterface {

    private UserCache userCache;
    private BotState nextState;

    public ThemeChoise(UserCache userCache, BotState botState) {
        this.userCache = userCache;
        this.nextState = botState;
    }

    @Override
    public SendMessage handle(Message message) {
        userCache.setState((int) (long) message.getChatId(), nextState);
        return new SendMessage().setText("Список тем:");
    }

    @Override
    public BotState getNextState() {
        return nextState;
    }
}
