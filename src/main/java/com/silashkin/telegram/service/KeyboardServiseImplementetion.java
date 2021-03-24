package com.silashkin.telegram.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Component
public class KeyboardServiseImplementetion implements KeyboardService {

    @Override
    public SendMessage createKeyboards(ArrayList<String> arrayList, SendMessage message) {

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        for (String string : arrayList) {
            KeyboardRow row = new KeyboardRow();
            row.add(new KeyboardButton(string));
            keyboard.add(row);
        }

        replyKeyboardMarkup.setKeyboard(keyboard);
        message.enableMarkdown(true);
        message.setReplyMarkup(replyKeyboardMarkup);

        return message;
    }

}
