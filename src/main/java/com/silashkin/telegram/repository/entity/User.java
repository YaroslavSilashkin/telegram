package com.silashkin.telegram.repository.entity;

import com.silashkin.telegram.Type;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private Integer phone;
    private Type type;
    private String name;
}

