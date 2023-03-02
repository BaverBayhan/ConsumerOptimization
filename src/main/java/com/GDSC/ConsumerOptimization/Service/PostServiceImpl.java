package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.DishWasherPost;
import com.GDSC.ConsumerOptimization.Entity.Post;
import com.GDSC.ConsumerOptimization.Entity.PostCategory;
import com.GDSC.ConsumerOptimization.Entity.WashingMachinePost;
import com.GDSC.ConsumerOptimization.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> getPostByUserToken(String userToken) {
        return postRepo.findByUserToken(userToken);
    }

    @Override
    public void savePost(Post post) {
        postRepo.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepo.delete(postRepo.getReferenceById(postId));
    }

    @Override
    public Post create_post(PostCategory category) {
        Post post = null;
        if(category.equals(PostCategory.DISHWASHER))
        {
            post = new DishWasherPost();
        }

        else if(category.equals(PostCategory.WASHING_MACHINE))
        {
            post=new WashingMachinePost();
        }
        return post;
    }
}
