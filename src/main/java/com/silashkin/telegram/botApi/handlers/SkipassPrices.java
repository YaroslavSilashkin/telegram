package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class SkipassPrices implements Handler {

    private final SendMessageService sendMessageService;

    private static final String SKIPASS_PRICES = "Цены на skipass: \n 1 подъём\t          80 руб \n 2 часа\t              800 руб \n 3 часа\t            1000 руб\n 5 часов\t          1200 руб";

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create(SKIPASS_PRICES, inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "SkipassPrices";
    }
}
