package com.silashkin.telegram;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
@Getter
@Setter
public class Ping {

//    @Value("${ping.url}")
//    private String url;
//
//    @Scheduled(fixedRateString = "${ping.period}")
//    public void pingMe() {
//        try {
//            URL url = new URL(getUrl());
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.connect();
//            System.out.println(url.getHost() + " " + connection.getResponseCode());
//            connection.disconnect();
//        } catch (IOException e) {
//        }
//    }
}
