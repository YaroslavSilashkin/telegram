package com.silashkin.telegram.botconfig;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Getter
public class TelegramBotConfig {

    private String botUsername;
    private String botPath;
}
