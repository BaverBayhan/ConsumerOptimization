package com.GDSC.ConsumerOptimization.Service;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import com.GDSC.ConsumerOptimization.Repository.PostRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
public class PaginationSortingTest {
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepo postRepo;

    @Test
    void pagination()
    {
        int pageSize=3;
        int pageNo=1;
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Post> page = postRepo.findAll(pageable);
        System.err.println(page.getTotalPages());

    }
}
