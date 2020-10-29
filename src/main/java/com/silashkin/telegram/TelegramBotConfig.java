package com.silashkin.telegram;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Getter
@Setter
public class TelegramBotConfig {

    private String username;
    private String path;
}
