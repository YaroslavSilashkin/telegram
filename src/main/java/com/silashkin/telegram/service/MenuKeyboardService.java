package com.silashkin.telegram.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuKeyboardService implements KeyboardService{

    @Override
    public SendMessage create(SendMessage message) {

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        KeyboardButton prices = new KeyboardButton("Цены");
        KeyboardButton contacts = new KeyboardButton("Контакты");
        KeyboardButton scheme = new KeyboardButton("Схема");
        KeyboardButton register = new KeyboardButton("Регистрация");
        KeyboardButton cam= new KeyboardButton("Камеры");

        row1.add(scheme);
        row1.add(register);
        row2.add(prices);
        row2.add(contacts);
        row3.add(cam);

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        replyKeyboardMarkup.setKeyboard(keyboard);

        message.enableMarkdown(true);

        message.setReplyMarkup(replyKeyboardMarkup);
        return message;
    }
}
