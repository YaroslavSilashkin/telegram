package com.silashkin.telegram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresRepository<String, UserCache> extends JpaRepository<String, UserCache> {

    String ByName();
}
