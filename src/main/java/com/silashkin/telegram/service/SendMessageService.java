package com.silashkin.telegram.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class MessageService {

public SendMessage create (final String text, final long chat, KeyboardService keyboardService){
    return keyboardService.create(new SendMessage()).setText(text).setChatId(chat);
}
}
