package com.GDSC.ConsumerOptimization.Dto;

import com.GDSC.ConsumerOptimization.Entity.Post.Post;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class FeedDto {
    private Post post;
    private String username;
    private Long id;
}
