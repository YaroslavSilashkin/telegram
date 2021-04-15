package com.silashkin.telegram.service;

import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class BotContentService implements ContentService {

    private Set<String> themes = Set.of();

    @Override
    public Set<String> getContent() {
        return themes;
    }
}
