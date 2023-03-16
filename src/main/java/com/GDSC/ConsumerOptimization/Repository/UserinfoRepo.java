package com.GDSC.ConsumerOptimization.Repository;

import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserinfoRepo extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByUsername(String username);
}
