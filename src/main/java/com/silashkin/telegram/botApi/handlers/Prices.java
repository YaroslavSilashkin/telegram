package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Prices implements HandlerInterface {

    private final SendMessageService sendMessageService;

    public Prices(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create("", inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "Цены";
    }
}
