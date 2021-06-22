package com.silashkin.telegram.repository;

import com.silashkin.telegram.botApi.HandlerInterface;
import com.silashkin.telegram.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRepository extends JpaRepository<User, Long> {
   User findBySki(int ski);
}
