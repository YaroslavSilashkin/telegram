package com.silashkin.telegram.service;

import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.scheduling.annotation.Scheduled;
import java.io.IOException;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
@Getter
public class PingService {

    @Value("${path}")
    private String url;

    @Scheduled(fixedRateString = "${ping.period}")
    public void pingMe() {
        try {
            URL url = new URL(getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            System.out.println(connection.getResponseCode());
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
