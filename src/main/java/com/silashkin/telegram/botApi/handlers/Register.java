package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Register implements HandlerInterface {

    SendMessageService sendMessageService;

    @Autowired
    public Register(SendMessageService sendMessageService){
        this.sendMessageService=sendMessageService;
    }

    @Override
    public SendMessage handle(Message message) {
        return sendMessageService.create("Регистрация", message.getChatId());
    }

    @Override
    public String getName() {
        return "Регистрация";
    }
}
