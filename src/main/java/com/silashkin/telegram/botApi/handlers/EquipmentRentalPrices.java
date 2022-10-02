package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class EquipmentRentalPrices implements Handler {

    private final SendMessageService sendMessageService;

    private static final String RENTAL_PRICES = "Цены на прокат: \n 2 часа\t          1050 руб\n 2 часа\t              1350 руб\n 3 часа\t            1600 руб\n 5 часов\t          1800 руб";

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create(RENTAL_PRICES, inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "EquipmentRentalPrices";
    }
}
