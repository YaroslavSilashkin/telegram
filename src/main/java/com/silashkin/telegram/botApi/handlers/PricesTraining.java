package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class PricesTraining implements HandlerInterface {

    private final SendMessageService sendMessageService;
    private final String price = "Цены на обучение с инструктором: \n 1 час\t          1500 руб";

    @Autowired
    public PricesTraining(SendMessageService sendMessageService){
        this.sendMessageService=sendMessageService;
    }

    @Override
    public SendMessage handle(Message message) {
        return sendMessageService.create(price,message.getChatId());
    }

    @Override
    public String getName() {
        return "PricesTraining";
    }
}
