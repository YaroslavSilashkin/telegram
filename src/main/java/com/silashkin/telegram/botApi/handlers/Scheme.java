package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class Scheme implements Handler {

    private final SendMessageService sendMessageService;

    public static final String RESORT_SCHEME = "Схема курорта";

    @Override
    public SendMessage handle(Message inputMessage) {
        return sendMessageService.create(RESORT_SCHEME, inputMessage.getChatId());
    }

    @Override
    public String getName() {
        return "Scheme";
    }
}
