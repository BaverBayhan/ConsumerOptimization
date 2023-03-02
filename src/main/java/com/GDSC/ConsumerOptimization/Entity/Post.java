package com.GDSC.ConsumerOptimization.Entity;


import com.GDSC.ConsumerOptimization.Utils.CustomPostSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonSerialize(using = CustomPostSerializer.class)
public abstract class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="description")
    String description;
    @Column(name="explanation")
    String explanation;
    @Column(name="userToken")
    String userToken;
    @Column(name="category")
    String category;
    @Column(name = "timeCreated")
    LocalDateTime time;
    @Column(name="likeCount")
    int like;

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
