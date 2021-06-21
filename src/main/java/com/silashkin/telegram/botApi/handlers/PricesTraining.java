package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class PricesTraining implements HandlerInterface {
    SendMessageService sendMessageService;

    @Autowired
    public PricesTraining(SendMessageService sendMessageService){
        this.sendMessageService=sendMessageService;
    }
    @Override
    public String getNextHandlerName() {
        return "Цены на обучение";
    }

    @Override
    public SendMessage handle(Message message) {
        return sendMessageService.create("Цены на обучени",message.getChatId());
    }

    @Override
    public String getName() {
        return "Цены на обучение";
    }
}
