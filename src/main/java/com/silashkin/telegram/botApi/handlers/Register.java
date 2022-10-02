package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.Handler;
import com.silashkin.telegram.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class Register implements Handler {

    private final SendMessageService sendMessageService;

    public static final String REGISTER = "Регистрация";

    @Override
    public SendMessage handle(Message message) {
        return sendMessageService.create(REGISTER, message.getChatId());
    }

    @Override
    public String getName() {
        return "Регистрация";
    }
}
