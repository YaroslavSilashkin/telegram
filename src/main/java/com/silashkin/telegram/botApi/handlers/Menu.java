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
public class Menu implements HandlerInterface {

    String nextHandlerName = "Start";

    @Override
    public String getNextHandlerName() {
        return nextHandlerName;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        SendMessage message = new SendMessage();
        Long chat = inputMessage.getChatId();
        String textMessage = "Основное меню";

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        row1.add(new KeyboardButton("Темы"));
        row2.add(new KeyboardButton("Нерешённые темы"));
        row3.add(new KeyboardButton("Помощь"));

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        replyKeyboardMarkup.setKeyboard(keyboard);

        message.enableMarkdown(true);
        message.setChatId(chat);
        message.setText(textMessage);
        message.setReplyMarkup(replyKeyboardMarkup);
        return message;
    }

    @Override
    public String getName() {
        return "Menu";
    }
}
