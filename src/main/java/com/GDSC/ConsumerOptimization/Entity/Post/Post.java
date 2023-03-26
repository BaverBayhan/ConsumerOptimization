package com.GDSC.ConsumerOptimization.Entity.Post;


import com.GDSC.ConsumerOptimization.Entity.User.User;
import com.GDSC.ConsumerOptimization.Entity.User.UserInfo;
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
    @Column(name="explanation")
    String explanation;
    @Column(name="category")
    String category;
    @Column(name = "timeCreated")
    LocalDateTime time;
    @Column(name="likeCount")
    int likeCount;

    @ManyToOne(cascade = CascadeType.MERGE  ,fetch = FetchType.EAGER)
    @JoinColumn(name = "userInfo",referencedColumnName = "id")
    UserInfo userInfo;

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
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

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", explanation='" + explanation + '\'' +
                ", category='" + category + '\'' +
                ", time=" + time +
                ", likeCount=" + likeCount +
                ", userInfo=" + userInfo +
                '}';
    }
}
