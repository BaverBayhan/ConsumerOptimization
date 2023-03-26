package com.GDSC.ConsumerOptimization.Dto;

import com.GDSC.ConsumerOptimization.Entity.Post.PostCategory;

import java.time.LocalDateTime;

public class PostDto {
    private String category;
    private String explanation;
    private LocalDateTime timeCreated;

    public PostDto(String category, String explanation, LocalDateTime timeCreated) {
        this.category = category;
        this.explanation = explanation;
        this.timeCreated = timeCreated;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }


}
