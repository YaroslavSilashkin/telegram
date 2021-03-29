package com.silashkin.telegram.service;

import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class BotContentService implements ContentService {

    private final Set<String> themes = Set.of("ООП", "JVM", "Java Core", "Java Collection Framework");

    @Override
    public Set<String> getContent() {
        return themes;
    }
}
