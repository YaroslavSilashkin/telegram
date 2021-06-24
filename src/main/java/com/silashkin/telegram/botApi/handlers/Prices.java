package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.KeyboardService;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Prices implements HandlerInterface {

    private final SendMessageService sendMessageService;
    private final KeyboardService priceKeyboardService;

    @Autowired
    public Prices(SendMessageService sendMessageService, KeyboardService priceKeyboardService) {
        this.sendMessageService = sendMessageService;
        this.priceKeyboardService = priceKeyboardService;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        return priceKeyboardService.create(sendMessageService.create("Цены", inputMessage.getChatId()));
    }

    @Override
    public String getName() {
        return "Цены";
    }
}
