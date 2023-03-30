package com.GDSC.ConsumerOptimization.Controller;
import com.GDSC.ConsumerOptimization.Dto.FeedDto;
import com.GDSC.ConsumerOptimization.Dto.PostDto;
import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import com.GDSC.ConsumerOptimization.Entity.Post.PostCategory;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
import com.GDSC.ConsumerOptimization.Repository.UserinfoRepo;
import com.GDSC.ConsumerOptimization.Security.JwtGenerator;
import com.GDSC.ConsumerOptimization.Service.PostService;
import com.GDSC.ConsumerOptimization.Utils.HttpFormContentUtils;
import com.GDSC.ConsumerOptimization.Utils.URLPaths;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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
    public ResponseEntity<String> getUsername(@RequestHeader("Authorization") @NotNull String token, @RequestBody @NotNull PostDto postDto)
            throws IOException, InterruptedException {
        String username = generator.getUsernameFromJWT(token.substring(7));
        Optional<UserInfo> userInfo = Optional.of(userinfoRepo.findByUsername(username).orElseThrow());
        Post post = postService.create_post(PostCategory.checkPostCategory(postDto.getCategory()));
        post.setCategory(postDto.getCategory());
        post.setExplanation(postDto.getExplanation());
        post.setTime(postDto.getTimeCreated());
        post.setUserInfo(userInfo.get());
        String response = HttpFormContentUtils.getUserDataFromSheetApi(URLPaths.detectPath(postDto.getCategory()),username);
        postService.injectCategoricalPostContent(post,HttpFormContentUtils.stringResponseToList(response));
        postService.savePost(post);
        return new ResponseEntity<>("Post created successfully",HttpStatus.CREATED);
    }


    @GetMapping(path = "/retrieveAllPosts")
    public ResponseEntity<List<Post>> getPostOfUser(@RequestHeader("Authorization") @NotNull String token)
    {
        String username = generator.getUsernameFromJWT(token.substring(7));
        Optional<UserInfo> userInfo = Optional.of(userinfoRepo.findByUsername(username).orElseThrow());
        Optional<List<Post>> posts = Optional.of(postService.getPostByUserInfo(userInfo.get()).orElseThrow());
        return new ResponseEntity<>(posts.get(),HttpStatus.OK);
    }

    @GetMapping(path = "/feed")
    public ResponseEntity<List<FeedDto>> discoverPosts(@RequestHeader("Authorization") @NotNull String token,
                                                       @RequestParam(name = "page") int page)
    {
        List<Post> posts = postService.feedGenerator(page);
        String username = generator.getUsernameFromJWT(token.substring(7));
        List<FeedDto> feedDtos = new ArrayList<>();
        for (Post post : posts) {
            FeedDto feedDto = FeedDto.builder().post(post).username(post.getUserInfo().getUsername()).build();
            feedDtos.add(feedDto);
        }
        return new ResponseEntity<>(feedDtos,HttpStatus.OK);
    }




}
