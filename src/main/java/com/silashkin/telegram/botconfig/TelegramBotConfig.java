package com.silashkin.telegram.botconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Getter
@Setter
public class TelegramBotConfig {

    private String BotUsername;
    private String BotPath;
}
