package com.silashkin.telegram.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public interface KeyboardService {

    SendMessage create(SendMessage sendMessage);
}
