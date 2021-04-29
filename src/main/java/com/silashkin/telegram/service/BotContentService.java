package com.silashkin.telegram.service;

import com.silashkin.telegram.repository.PostgresRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.User;

@Component
public class BotContentService implements ContentServiceInterface {

    private PostgresRepository<String, User> postgresRepository;
    
    private Set<String> themes = Set.of();

    @Autowired
    public BotContentService(PostgresRepository<String, User> postgresRepository) {
        this.postgresRepository = postgresRepository;
    }

    @Override
    public Set<String> getContent() {
        return themes;
    }
}
