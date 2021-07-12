package com.silashkin.telegram.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@Component
public class PriceKeyboardService implements KeyboardService{

    @Override
    public SendMessage create(SendMessage sendMessage) {
        InlineKeyboardButton risePrices = new InlineKeyboardButton().setText("Цены на skipass").setCallbackData("RisePrices");
        InlineKeyboardButton equipmentRentalPrices = new InlineKeyboardButton().setText("Цены на снаряжение").setCallbackData("EquipmentRentalPrices");
        InlineKeyboardButton pricesTraining = new InlineKeyboardButton().setText("Цены на обучение").setCallbackData("PricesTraining");

        List<List<InlineKeyboardButton>> rows = List.of(List.of(risePrices), List.of(equipmentRentalPrices), List.of(pricesTraining));

        sendMessage.enableMarkdown(true);
        sendMessage.setReplyMarkup(new InlineKeyboardMarkup().setKeyboard(rows));
        return sendMessage;
    }
}
