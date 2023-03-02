package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.DishWasherPost;
import com.GDSC.ConsumerOptimization.Entity.Post;
import com.GDSC.ConsumerOptimization.Entity.PostCategory;
import com.GDSC.ConsumerOptimization.Entity.WashingMachinePost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    PostService service;

    @Test
    public void savePost() {
        PostCategory category = PostCategory.WASHING_MACHINE;
        Post post = service.create_post(category);
        if(post instanceof DishWasherPost)
        {
            DishWasherPost dishWasherPost = (DishWasherPost) post;
            dishWasherPost.setDishWasherBrand("bosch");
            dishWasherPost.setDishSoapBrand("calgon");
            dishWasherPost.setDescription("desc1");
            dishWasherPost.setExplanation("expl1");
            dishWasherPost.setUserToken("156as87f");
            dishWasherPost.setTime(LocalDateTime.now());
            dishWasherPost.setCategory(category.getName());
        }
        else if(post instanceof WashingMachinePost)
        {
            WashingMachinePost washingMachinePost = (WashingMachinePost) post;
            washingMachinePost.setWashingMachineBrand("beko");
            washingMachinePost.setDetergentBrand("yumos");
            washingMachinePost.setDescription("desc3");
            washingMachinePost.setExplanation("expl3");
            washingMachinePost.setUserToken("156as87asdf");
            washingMachinePost.setTime(LocalDateTime.now());
            washingMachinePost.setCategory(category.getName());

        }
        service.savePost(post);
    }

    @Test
    public void getPostByUserToken()
    {
        String userToken ="156as87f";
        System.out.println(service.getPostByUserToken(userToken));
    }


}