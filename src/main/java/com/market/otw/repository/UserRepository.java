package com.market.otw.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.market.otw.domain.User;
import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByLoginIdAndPassword( String loginId, String password);
    Optional<User> findById(Long id);
    Optional<User> findByLoginId(String loginId);
    Optional<User> findByLoginIdAndPassword(String loginId, String password);

    @Modifying
    @Transactional
    @Query("DELETE FROM User e WHERE e.regisnDate < :oneMonthAgo")
    void deleteByResignDateBefore(@Param("oneMonthAgo") String oneMonthAgo);
}
