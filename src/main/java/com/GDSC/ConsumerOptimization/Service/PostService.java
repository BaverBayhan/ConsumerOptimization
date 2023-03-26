package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import com.GDSC.ConsumerOptimization.Entity.Post.PostCategory;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface PostService {
    void savePost(Post post);
    void deletePost(Long postId);
    Post create_post(PostCategory category);
    Optional<List<Post>> getPostByUserInfo(UserInfo userInfo);
    void injectCategoricalPostContent(Post post , List<String> postList) throws IOException, InterruptedException;

}
