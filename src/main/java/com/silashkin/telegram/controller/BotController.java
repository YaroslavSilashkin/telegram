package com.silashkin.telegram.controller;

import com.silashkin.telegram.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class BotController {

    private final TelegramBot telegramBot;

    @Autowired
    public BotController(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostMapping(path = "/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
    }
}
