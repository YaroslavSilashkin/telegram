package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.KeyboardService;
import com.silashkin.telegram.service.MenuKeyboardService;
import com.silashkin.telegram.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Menu implements HandlerInterface {

    private final SendMessageService sendMessageService;
    private final KeyboardService keyboardService;

    @Autowired
    public Menu(SendMessageService messageService, MenuKeyboardService keyboardService){
    this.sendMessageService = messageService;
    this.keyboardService = keyboardService;
}

    @Override
    public SendMessage handle(Message inputMessage) {

        return keyboardService.create(sendMessageService.create("Основное меню", inputMessage.getChatId()));
    }

    @Override
    public String getName() {
        return "Меню";
    }
}
