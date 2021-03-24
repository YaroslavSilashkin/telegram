package com.silashkin.telegram.service;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public interface KeyboardService {

    SendMessage createKeyboards(ArrayList<String> arrayList, SendMessage sendMessage);
}
