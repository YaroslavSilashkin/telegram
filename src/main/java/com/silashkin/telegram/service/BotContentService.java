package com.silashkin.telegram.service;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class BotContentService implements ContentServiceInterface {

    private Set<String> themes = Set.of();

    @Override
    public Set<String> getContent() {
        return themes;
    }
}
