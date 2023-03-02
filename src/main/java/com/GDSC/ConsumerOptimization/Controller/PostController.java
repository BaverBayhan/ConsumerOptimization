package com.GDSC.ConsumerOptimization.Controller;

import com.GDSC.ConsumerOptimization.Entity.Post;
import com.GDSC.ConsumerOptimization.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(path = "api/v1/post")
public class PostController {
    @Autowired
    PostService service;
    @GetMapping("/{userToken}")
    public ResponseEntity<List<Post>> getPost(@PathVariable String userToken)
    {
        return new ResponseEntity<>(service.getPostByUserToken(userToken),HttpStatus.OK);
    }
}
