package com.silashkin.telegram.service;

import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class BotContent implements Content {

    private final Set<String> themes = Set.of("ООП", "JVM", "Java Core", "Java Collection Framework");

    @Override
    public String getContent() {
        return themes.toString();
    }
}
