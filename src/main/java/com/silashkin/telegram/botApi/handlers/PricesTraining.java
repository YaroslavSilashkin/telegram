package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class PricesTraining implements Handler {

    private final SendMessageService sendMessageService;

    private static final String TRAINING_PRICES = "Цены на обучение с инструктором: \n 1 час\t          1500 руб";

    @Override
    public SendMessage handle(Message message) {
        return sendMessageService.create(TRAINING_PRICES, message.getChatId());
    }

    @Override
    public String getName() {
        return "PricesTraining";
    }
}
