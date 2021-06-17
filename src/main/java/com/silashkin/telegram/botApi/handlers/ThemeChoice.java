package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Component
public class ThemeChoice implements HandlerInterface {

    private final String nextStateName = "/ThemeChoice";

    @Override
    public String getNextHandlerName() {
        return nextStateName;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        SendMessage message = new SendMessage();
        Long chat = inputMessage.getChatId();
        String textMessage = "Список тем";


        message.setChatId(chat);
        message.setText(textMessage);

        return message;
    }

    @Override
    public String getName() {
        return "ThemeChoice";
    }
}
