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
public class Menu implements Handler {

    public static final String MAIN_MENU = "Основное меню";
    private final SendMessageService sendMessageService;
    private final KeyboardService keyboardService;

    @Override
    public SendMessage handle(Message inputMessage) {
        return keyboardService.create(sendMessageService.create(MAIN_MENU, inputMessage.getChatId()));
    }

    @Override
    public String getName() {
        return "Меню";
    }
}
