package com.silashkin.telegram.repository.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Users implements Serializable {

    @javax.persistence.Id
    private long chat;
    private int qwe;
    String handlerName;

    public Users() {
    }

    public Users(long chat, int qwe, String handlerName) {
        this.chat = chat;
        this.qwe = qwe;
        this.handlerName = handlerName;
    }
}
