package com.silashkin.telegram.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceKeyboardService implements KeyboardService{

    @Override
    public SendMessage create(SendMessage sendMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton risePrices = new InlineKeyboardButton().setText("Цены на skipass");
        risePrices.setCallbackData("RisePrices");
        List<InlineKeyboardButton> inlineKeyboardButtonsRow1 = new ArrayList<>();
        inlineKeyboardButtonsRow1.add(risePrices);
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(inlineKeyboardButtonsRow1);
        inlineKeyboardMarkup.setKeyboard(rows);
        sendMessage.enableMarkdown(true);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }
}
