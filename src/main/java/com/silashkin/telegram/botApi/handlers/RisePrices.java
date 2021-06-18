package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import java.util.ArrayList;
import java.util.List;

import com.silashkin.telegram.service.KeyboardService;
import com.silashkin.telegram.service.SendMessageService;
import com.silashkin.telegram.service.StartKeyboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
@Component
public class RisePrices implements HandlerInterface {

    private final SendMessageService sendMessageService;

    @Autowired
    public RisePrices (SendMessageService messageService){
        this.sendMessageService = messageService;
    }

    @Override
    public String getNextHandlerName() {
        return "/Price";
    }

    @Override
    public SendMessage handle(Message inputMessage) {

        return sendMessageService.create("Цены на скипас",inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
