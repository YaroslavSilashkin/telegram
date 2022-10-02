package com.silashkin.telegram.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class SendMessageService {

    public SendMessage create(final String text, final long chat) {
        return new SendMessage().setText(text).setChatId(chat);
    }
}
