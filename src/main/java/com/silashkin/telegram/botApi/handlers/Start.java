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
public class Start implements Handler {
    private final SendMessageService sendMessageService;
    private final KeyboardService keyboardService;

    private static final String WELCOME_MESSAGE = "Привет, %s! Это бот горнолыжного курорта";

    @Override
    public SendMessage handle(Message inputMessage) {
        final String textMessage = String.format(WELCOME_MESSAGE, inputMessage.getChat().getFirstName());
        return keyboardService.create(sendMessageService.create(textMessage, inputMessage.getChatId()));
    }

    @Override
    public String getName() {
        return "/start";
    }
}
