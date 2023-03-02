package com.GDSC.ConsumerOptimization.Repository;

import com.GDSC.ConsumerOptimization.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
     List<Post> findByUserToken(String userToken);
}
