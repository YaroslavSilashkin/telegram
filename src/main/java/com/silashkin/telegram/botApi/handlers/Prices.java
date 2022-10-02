package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.KeyboardService;
import com.silashkin.telegram.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class Prices implements Handler {

    private final SendMessageService sendMessageService;
    private final KeyboardService priceKeyboardService;

    public static final String PRICES = "Цены";

    @Override
    public SendMessage handle(Message inputMessage) {
        return priceKeyboardService.create(sendMessageService.create(PRICES, inputMessage.getChatId()));
    }

    @Override
    public String getName() {
        return "Цены";
    }
}
