package com.silashkin.telegram.service;

import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public interface ContentService {

    Set<String> getContent();
}
