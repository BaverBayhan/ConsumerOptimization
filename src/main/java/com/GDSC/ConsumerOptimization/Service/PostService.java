package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.Post;
import com.GDSC.ConsumerOptimization.Entity.PostCategory;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    List<Post> getPostByUserToken(String user_id);
    void savePost(Post post);
    void deletePost(Long postId);
    Post create_post(PostCategory category);

}
