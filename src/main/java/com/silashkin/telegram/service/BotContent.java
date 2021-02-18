package com.silashkin.telegram.service;

import java.util.Set;

public class BotContent implements Content {

    private Set<String> themes;

    {
        themes.add("1");
    }

    @Override
    public Set<String> getContent() {

        return themes;
    }

}
