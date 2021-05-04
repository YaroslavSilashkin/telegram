package com.silashkin.telegram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRepository<String, Users> extends JpaRepository<String, Users> {

    //Users ByName(String name);
}
