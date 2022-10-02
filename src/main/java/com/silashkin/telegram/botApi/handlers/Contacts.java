package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Contacts implements Handler {

    private final SendMessageService sendMessageService;
    private String contacts = "Тел. +555555555";

    public Contacts(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create(contacts, inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "Контакты";
    }
}
