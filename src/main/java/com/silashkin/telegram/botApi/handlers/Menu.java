package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.KeyboardService;
import com.silashkin.telegram.service.MenuKeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Menu implements HandlerInterface {

    private final String nextHandlerName = "/Start";
    private final KeyboardService keyboardService;

@Autowired
public Menu (MenuKeyboardService keyboardService){
    this.keyboardService = keyboardService;
}
    @Override
    public String getNextHandlerName() {
        return nextHandlerName;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        SendMessage message = new SendMessage();
        Long chat = inputMessage.getChatId();
        String textMessage = "Основное меню";

        message = keyboardService.create(message);
        message.setChatId(chat);
        message.setText(textMessage);
        return message;
    }

    @Override
    public String getName() {
        return "/Menu";
    }
}
