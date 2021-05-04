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
public class ThemeChoise implements HandlerInterface {

    private final String nextStateName = "ThemeChoise";

    @Override
    public String getNextHandlerName() {
        return nextStateName;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        SendMessage message = new SendMessage();
        Long chat = inputMessage.getChatId();
        String textMessage = "Список тем";

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        KeyboardRow row4 = new KeyboardRow();
        KeyboardRow row5 = new KeyboardRow();

        row1.add(new KeyboardButton("ООП"));
        row2.add(new KeyboardButton("JVM"));
        row3.add(new KeyboardButton("Java Core"));
        row4.add(new KeyboardButton("Java Collection Framework"));
        row5.add(new KeyboardButton("Menu"));

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboard.add(row5);
        replyKeyboardMarkup.setKeyboard(keyboard);
        message.enableMarkdown(true);
        message.setChatId(chat);
        message.setText(textMessage);
        message.setReplyMarkup(replyKeyboardMarkup);
        return message;
    }

    @Override
    public String getName() {
        return "ThemeChoise";
    }
}
