package com.GDSC.ConsumerOptimization.Controller;
import com.GDSC.ConsumerOptimization.Dto.PostDto;
import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
import com.GDSC.ConsumerOptimization.Repository.UserinfoRepo;
import com.GDSC.ConsumerOptimization.Security.JwtGenerator;
import com.GDSC.ConsumerOptimization.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/post")
public class PostController {
    @Autowired
    JwtGenerator generator;

    @Autowired
    PostService postService;

    @Autowired
    UserinfoRepo userinfoRepo;


    @PostMapping(path = "/save")
    public String getUsername(@RequestHeader("Authorization") String token, @RequestBody PostDto postDto)
            throws IOException, InterruptedException {
        String username = generator.getUsernameFromJWT(token.substring(7));
        Optional<UserInfo> userInfo = Optional.of(userinfoRepo.findByUsername(username).orElseThrow());
        Post post = postService.create_post(PostDto.checkCategory(postDto.getCategory()));
        post.setCategory(postDto.getCategory());
        post.setExplanation(postDto.getExplanation());
        post.setTime(postDto.getTimeCreated());
        post.setUserInfo(userInfo.get());
        postService.injectCategoricalPostContent(post);
        postService.savePost(post);
        return "Post Created Successfully";
    }


    @GetMapping(path = "/retrieve")
    public ResponseEntity<List<Post>> getPostOfUser(@RequestHeader("Authorization") String token)
    {
        String username = generator.getUsernameFromJWT(token.substring(7));
        Optional<UserInfo> userInfo = Optional.of(userinfoRepo.findByUsername(username).orElseThrow());
        Optional<List<Post>> posts = Optional.of(postService.getPostByUserInfo(userInfo.get()).orElseThrow());
        return new ResponseEntity<>(posts.get(),HttpStatus.OK);
    }




}
