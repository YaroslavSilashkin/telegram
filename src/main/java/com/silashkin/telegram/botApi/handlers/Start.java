package com.silashkin.telegram.botApi.handlers;
import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.service.KeyboardService;
import com.silashkin.telegram.service.SendMessageService;
import com.silashkin.telegram.service.StartKeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class Start implements HandlerInterface {
    private final SendMessageService sendMessageService;
    private final KeyboardService keyboardService;

    @Autowired
    public Start(SendMessageService messageService, StartKeyboardService keyboardService){
        this.sendMessageService = messageService;
        this.keyboardService=keyboardService;
    }

    @Override
    public SendMessage handle(Message inputMessage) {
        final String textMessage = "Привет, " + inputMessage.getChat().getFirstName() + "! Это бот горнолыжного курорта";
        return keyboardService.create(sendMessageService.create(textMessage, inputMessage.getChatId()));
    }

    @Override
    public String getName() {
        return "/start";
    }
}
