package com.silashkin.telegram.repository.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long chat;
    private String handlerName;
    private int ski;
}
