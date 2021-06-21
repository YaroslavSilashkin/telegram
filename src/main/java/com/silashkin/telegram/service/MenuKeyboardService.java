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
        KeyboardRow row4 = new KeyboardRow();
        KeyboardRow row5 = new KeyboardRow();

        KeyboardButton risePrices = new KeyboardButton("Цены на skipass");
        KeyboardButton equipmentRentalPrices = new KeyboardButton("Цены на прокат");
        KeyboardButton contacts = new KeyboardButton("Контакты");
        KeyboardButton register = new KeyboardButton("Регистрация");
        KeyboardButton scheme = new KeyboardButton("Схема");

        row1.add(scheme);
        row2.add(risePrices);
        row3.add(equipmentRentalPrices);
        row4.add(contacts);
        row5.add(register);

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboard.add(row5);

        replyKeyboardMarkup.setKeyboard(keyboard);

        message.enableMarkdown(true);

        message.setReplyMarkup(replyKeyboardMarkup);
        return message;
    }
}
