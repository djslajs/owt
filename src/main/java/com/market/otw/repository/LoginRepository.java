package com.market.otw.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.market.otw.domain.Login;

interface LoginFailCount {
    Long getFailCount();
}

public interface LoginRepository extends JpaRepository<Login, Long> {
    boolean existsByLoginId(String loginId);
    Optional<Login> findById(Long id);
    Optional<Login> findByLoginId(String loginId);
}

