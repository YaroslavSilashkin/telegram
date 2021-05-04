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

/*
 */
@Component
public class Start implements HandlerInterface {

    private String nextState = "ThemeChoise";

    @Override
    public String getNextHandlerName() {
        return nextState;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        SendMessage message = new SendMessage();
        Long chat = inputMessage.getChatId();
        String textMessage = "Привет, это бот горнолыжного курорта";

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Начать"));
        keyboard.add(row1);
        replyKeyboardMarkup.setKeyboard(keyboard);

        message.enableMarkdown(true);
        message.setChatId(chat);
        message.setText(textMessage);
        message.setReplyMarkup(replyKeyboardMarkup);

        return message;
    }

    @Override
    public String getName() {
        return "Start";
    }
}
