package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Dto.PostDto;
import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import com.GDSC.ConsumerOptimization.Entity.Post.PostCategory;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
import com.GDSC.ConsumerOptimization.Repository.UserinfoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    PostService postService;



    @Autowired
    UserinfoRepo userinfoRepo;
/*    @Test
    public void savePost() {
        PostCategory category = PostCategory.DISHWASHER;
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
    }*/





    @Test
    public void userInfoCreate()
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(21);
        userInfo.setUsername("baver1234");
        userInfo.setCity("Ankara");
        userInfo.setJob("pcMüh");
        userInfo.setSex("male");
        userInfo.setAnnualSalary(5000);
        userInfo.setCivilStatus("married");

        userinfoRepo.save(userInfo);


    }

    @Test
    public void getUserInfo()
    {
        String username = "baver1234";
        Optional<UserInfo> userInfo = userinfoRepo.findByUsername(username);
        System.err.println(userInfo.get());

    }

    @Test
    public void postCreation()
    {
        String username = "baver1234";
        PostDto postDto = new PostDto("Washing Machine","explanation",LocalDateTime.now());
        Post post = postService.create_post(PostCategory.checkPostCategory(postDto.getCategory()));
        post.setCategory(postDto.getCategory());
        post.setExplanation(postDto.getExplanation());
        post.setTime(postDto.getTimeCreated());
        post.setUserInfo(userinfoRepo.findByUsername(username).get());
        postService.savePost(post);
    }

    @Test
    public void fbun()
    {
        String username = "baver1234";
        Optional<UserInfo> userInfo = userinfoRepo.findByUsername(username);
        System.err.println(userInfo.get());
    }

    @Test
    public void getPost()
    {
        String username = "baver1234";
        Optional<UserInfo> userInfo = userinfoRepo.findByUsername(username);
        Optional<List<Post>> post = postService.getPostByUserInfo(userInfo.get());

        System.err.println(post.get());




    }


}