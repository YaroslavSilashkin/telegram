package com.silashkin.telegram.service;

import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class BotContent implements Content {

    private Set<String> themes = Set.of("ООП", "JVM", "Java Core", "Java Collection Framework");

    @Override
    public Set<String> getContent() {
        return themes;
    }

}
