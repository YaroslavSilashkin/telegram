package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Contacts implements HandlerInterface {

    private final SendMessageService sendMessageService;

    public Contacts(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public String getNextHandlerName() {
        return "Contacts";
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create("Контакты", inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "Контакты";
    }
}
