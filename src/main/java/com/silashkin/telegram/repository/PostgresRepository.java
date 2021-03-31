package com.silashkin.telegram.repository;

import com.silashkin.telegram.cache.UserCache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresRepository<String, UserCache> extends JpaRepository<String, UserCache> {

    public String ByName();
}
