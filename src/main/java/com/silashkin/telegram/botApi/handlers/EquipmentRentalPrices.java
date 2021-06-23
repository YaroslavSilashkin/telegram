package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class EquipmentRentalPrices implements HandlerInterface {

    private final SendMessageService sendMessageService;
    String price = "Цены на прокат: \n 2 часа\t          1050 руб\n 2 часа\t              1350 руб\n 3 часа\t            1600 руб\n 5 часов\t          1800 руб";

    @Autowired
    public EquipmentRentalPrices (SendMessageService messageService){
        this.sendMessageService = messageService;
    }

    @Override
    public SendMessage handle(Message inputMessage) {

        return sendMessageService.create(price,inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "Цены на прокат";
    }
}
