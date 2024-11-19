package com.market.otw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.market.otw.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
