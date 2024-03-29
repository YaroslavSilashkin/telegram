package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class Contacts implements Handler {

    private final SendMessageService sendMessageService;

    private static final String CONTACTS = "Тел. +555555555";

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create(CONTACTS, inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "Контакты";
    }
}
