package com.silashkin.telegram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRepository<String, User> extends JpaRepository<String, User> {
    //User ByName(String name);
}
