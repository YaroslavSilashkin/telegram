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

    @Autowired
    public EquipmentRentalPrices (SendMessageService messageService){
        this.sendMessageService = messageService;
    }

    @Override
    public String getNextHandlerName() {
        return "/EquipmentRentalPrices";
    }

    @Override
    public SendMessage handle(Message inputMessage) {

        return sendMessageService.create("Цены на прокат",inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
