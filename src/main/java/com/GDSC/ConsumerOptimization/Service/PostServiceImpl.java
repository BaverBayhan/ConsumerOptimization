package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.Post.*;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
import com.GDSC.ConsumerOptimization.Repository.PostRepo;
import com.GDSC.ConsumerOptimization.Repository.UserinfoRepo;
import com.GDSC.ConsumerOptimization.Utils.HttpFormContentUtils;
import com.GDSC.ConsumerOptimization.Utils.URLPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepo postRepo;

    @Autowired
    UserinfoRepo userinfoRepo;

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
            post = new WashingMachinePost();
        }

        else if(category.equals(PostCategory.GENERIC))
        {
            post = new GenericTypePost();
        }
        return post;
    }

    @Override
    public Optional<List<Post>> getPostByUserInfo(UserInfo userInfo) {
        return postRepo.findByUserInfo(userInfo);
    }

    @Override
    public void injectCategoricalPostContent(Post post) throws IOException, InterruptedException {

        String category = post.getCategory();
        String responseString = HttpFormContentUtils.getFromSheetApi(category,post.getUserInfo().getUsername());
        List<String> response = HttpFormContentUtils.stringResponseToList(responseString);

        String username = post.getUserInfo().getUsername();
        if(post.getCategory().equals(PostCategory.WASHING_MACHINE.getName()))
        {
            WashingMachinePost washingMachinePost = (WashingMachinePost) post;
        }
        else if(post.getCategory().equals(PostCategory.DISHWASHER.getName()))
        {
            DishWasherPost dishWasherPost = (DishWasherPost) post;
        }
        else if(post.getCategory().equals(PostCategory.GENERIC.getName()))
        {
            GenericTypePost genericTypePost = (GenericTypePost) post;
            genericTypePost.setFormContent(response.get(2));
        }
    }


}
