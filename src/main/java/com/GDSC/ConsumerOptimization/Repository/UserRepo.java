package com.GDSC.ConsumerOptimization.Repository;

import com.GDSC.ConsumerOptimization.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}
