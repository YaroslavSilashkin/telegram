package com.silashkin.telegram.botApi.handlers;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.repository.PostgresRepository;
import com.silashkin.telegram.repository.entity.User;
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
    private final String nextState = "Menu";
    private final PostgresRepository postgresRepository;

    @Autowired
    public Start(SendMessageService messageService, StartKeyboardService keyboardService, PostgresRepository postgresRepository){
        this.sendMessageService = messageService;
        this.keyboardService=keyboardService;
        this.postgresRepository = postgresRepository;
    }

    @Override
    public String getNextHandlerName() {
        return nextState;
    }

    @Override
    public SendMessage handle(Message inputMessage) {

        final String textMessage = "Привет! Это бот горнолыжного курорта";
        User user = new User();
        user.setChat(inputMessage.getChatId());
        postgresRepository.save(user);
        return keyboardService.create(sendMessageService.create(textMessage, inputMessage.getChatId()));
    }

    @Override
    public String getName() {
        return "/start";
    }
}
