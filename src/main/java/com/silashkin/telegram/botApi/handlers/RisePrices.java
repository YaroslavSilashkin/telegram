package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class RisePrices implements Handler {

    private final SendMessageService sendMessageService;
    String price = "Цены на skipass: \n 1 подъём\t          80 руб \n 2 часа\t              800 руб \n 3 часа\t            1000 руб\n 5 часов\t          1200 руб";

    @Autowired
    public RisePrices (SendMessageService messageService){
        this.sendMessageService = messageService;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create(price, inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "RisePrices";
    }
}
