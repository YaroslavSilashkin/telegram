package com.silashkin.telegram.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuKeyboardService implements KeyboardService {

    @Override
    public SendMessage create(SendMessage message) {

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        var row1 = new KeyboardRow();
        var row2 = new KeyboardRow();
        var row3 = new KeyboardRow();

        var pricesButton = new KeyboardButton("Цены");
        var contactsButton = new KeyboardButton("Контакты");
        var schemeButton = new KeyboardButton("Схема");
        var registerButton = new KeyboardButton("Регистрация");
        var camerasButton = new KeyboardButton("Камеры");

        row1.add(schemeButton);
        row1.add(registerButton);
        row2.add(pricesButton);
        row2.add(contactsButton);
        row3.add(camerasButton);

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        replyKeyboardMarkup.setKeyboard(keyboard);

        message.enableMarkdown(true);

        message.setReplyMarkup(replyKeyboardMarkup);
        return message;
    }
}
