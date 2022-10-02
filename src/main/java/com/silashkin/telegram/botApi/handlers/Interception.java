package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class Interception implements Handler {

    public static final String FUNCTIONAL_IN_TEST = "Функционал только тестируется";
    private final SendMessageService sendMessageService;

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create(FUNCTIONAL_IN_TEST, inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "Interception";
    }
}
