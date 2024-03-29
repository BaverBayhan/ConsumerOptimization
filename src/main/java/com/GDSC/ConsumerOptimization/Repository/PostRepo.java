package com.GDSC.ConsumerOptimization.Repository;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post,Long> {
    Optional<List<Post>> findByUserInfo(UserInfo userInfo);
}
