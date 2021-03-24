package com.silashkin.telegram.botApi;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public interface HandlerInterface {

    String getNextHandlerName();

    SendMessage handle(Message message);

    String getName();
}
